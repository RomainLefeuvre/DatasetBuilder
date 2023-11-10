package fr.inria.diverse.requests;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.inria.diverse.utils.SwhUtils;
import fr.inria.model.CookingStatus;
import fr.inria.model.Snapshot;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class SwhClient {
    static Logger logger = LogManager.getLogger(SwhClient.class);
    SwhService swhService;

    public SwhClient(String token) {
        // create the retrofit object //
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add the authorization header to the request
        if (token != null || token != "" || token != "unknown") {
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .addHeader("Authorization",
                                    "Bearer " + token)
                            .method(original.method(), original.body())
                            .build();
                    return chain.proceed(request);
                }
            });
        }
        OkHttpClient swhClient = httpClient.build();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);// ignore unknown properties so
                                                                                         // that we can deserialize
                                                                                         // without some fields
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS, true);

        Retrofit swhRetrofit = new Retrofit.Builder()
                .baseUrl("https://archive.softwareheritage.org/api/1/")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .client(swhClient)
                .build();
        swhService = swhRetrofit.create(SwhService.class);

    }

    /**
     * Request the cooking of a bundle for a list of software heritage id.
     * 
     * @param bundleType the type of bundle to be created (either flat, gitfast or
     *                   git-bare)
     * @param swhId      the software heritage id
     * @return a response containing the current state of cooking
     */
    public List<CookingStatus> requestCooking(String bundleType, List<String> swhId) {
        List<CookingStatus> status = new LinkedList<>();
        CountDownLatch latch = new CountDownLatch(swhId.size());

        swhId.stream().map(s -> SwhUtils.getSwhIdFromRevId(s)).forEach(s -> {
            swhService.startCooking(bundleType, s).enqueue(new Callback<CookingStatus>() {

                @Override
                public void onResponse(Call<CookingStatus> call, retrofit2.Response<CookingStatus> response) {
                    if (response.isSuccessful()) {
                        status.add(response.body());

                    } else {
                        logger.error("Error while requesting cooking for " + s + " " + response);
                    }
                    latch.countDown();
                }

                @Override
                public void onFailure(Call<CookingStatus> call, Throwable t) {
                    logger.error("Error while requesting cooking for " + s, t);
                    latch.countDown();
                }

            });
        });
        try {
            logger.info("Waiting for all cooking requests to finish");
            latch.await();

            logger.info("All cooking requests finished, result " + status);
        } catch (InterruptedException e) {
            logger.error("Program interrupted", e);
            e.printStackTrace();
        }
        return status;
    }

    /**
     * Receives the cooked bundle if it exists.
     * 
     * @param bundleType   the type of bundle to be created
     * @param swhId        the software heritage id
     * @param outputFolder the folder where the bundle will be placed
     * @return the list of remaining swhid to cook
     */
    public List<String> DownloadCookedIfReady(String bundleType, LinkedList<String> swhIds, String outputFolder) {
        CountDownLatch latch = new CountDownLatch(swhIds.size());

        @SuppressWarnings("unchecked")
        LinkedList<String> remainingSwhIds = (LinkedList<String>) swhIds.clone();

        swhIds.stream().forEach(currentSwhId -> {
            swhService.receivedCooked(bundleType, currentSwhId).enqueue(new Callback<ResponseBody>() {

                @Override
                public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                    if (response.code() == 404) {
                        logger.info("Bundle for " + currentSwhId + " not ready yet");
                        latch.countDown();
                        return;
                    }
                    remainingSwhIds.remove(currentSwhId);
                    String extension = bundleType.equals("gitfast") ? ".gitfast.gz"
                            : bundleType.equals("git-bare") ? ".git.tar" : ".tar.gz";

                    File currentRevFile = new File(
                            outputFolder + "/" + currentSwhId + extension);
                    // either a tar.gz, a gitfast.gz or a git.tar file
                    currentRevFile.getParentFile().mkdirs();
                    try {
                        currentRevFile.createNewFile();
                        byte[] bytes;
                        bytes = response.body().bytes();
                        Files.write(currentRevFile.toPath(), bytes);
                        logger.info("Bundle for " + currentSwhId + extension + " written");
                    } catch (IOException e) {
                        logger.error("Error while writing bundle for " + currentSwhId, e);
                    }
                    latch.countDown();
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    logger.error("Error while requesting cooked for " + currentSwhId, t);
                    latch.countDown();
                }

            });
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            logger.error("Program interrupted", e);
            e.printStackTrace();
        }
        return remainingSwhIds;
    }

    /**
     * gets the first revision of every snapshot in the import map
     * TODO this method does not finish, for some reason something is still running,
     * using multiple threads works but not async
     * 
     * @param importMap the import map
     * @return List containing the ids of the first revision of every snapshot
     */
    public List<String> requestRevisionsFromSwhImportMap(Map<String, List<String>> importMap) {

        ConcurrentLinkedQueue<String> revisions = new ConcurrentLinkedQueue<>();

        int total = importMap.values().stream().mapToInt(List::size).sum();

        CountDownLatch latch = new CountDownLatch(total);
        logger.info("latch size = " + total);

        importMap.forEach((k, v) -> {
            v.stream()
                    .map(swhid -> SwhUtils.getSnapShotIdFromSwhId(swhid))
                    .forEach(snpId -> {
                        logger.info("Requesting snapshot " + snpId);

                        swhService.requestSnapshot(snpId).enqueue(new Callback<Snapshot>() {

                            @Override
                            public void onResponse(Call<Snapshot> call, retrofit2.Response<Snapshot> response) {
                                // the target of head branch is sometimes an aliases, so we have to get the id
                                // from the url
                                 if(response.isSuccessful()){
                                revisions.add(response.body().getBranches()
                                        .getOrDefault("HEAD", response.body().getBranches().get("refs/heads/master"))
                                        .getTargetUrl().split("/")[6]);
                                 }
                                 else{
                                    String errorBody="";
                                    try {
                                    errorBody = response.errorBody().string();
                                      } catch (IOException e) {
                                    throw new RuntimeException("Error while reading error body "+snpId);
                                }
                                logger.error("Error while requesting snapshot error_body:"+errorBody+" " + snpId);
                            }
                                 
                                latch.countDown();
                            }

                            @Override
                            public void onFailure(Call<Snapshot> call, Throwable t) {
                                logger.error("Error while requesting snapshot " + snpId, t);
                                latch.countDown();
                            }

                        });

                    });
        });
        try {
            logger.info("Waiting for all revisions requests to finish");
            latch.await();

            logger.info("All revision requests finished, revisions " + revisions);
        } catch (InterruptedException e) {
            logger.error("Program interrupted", e);
            e.printStackTrace();
        }
        // cast to list
        return revisions.stream().collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
    }

}

/*
 * importMap.forEach((k, v) -> {
 * v.stream()
 * .map(swhid -> SwhUtils.getSnapShotIdFromSwhId(swhid))
 * .forEach(snpId -> {
 * logger.info("Requesting snapshot " + snpId);
 * 
 * //start a new thread that requests the snapshot
 * new Thread(() -> {
 * try {
 * Snapshot snp = swhService.requestSnapshot(snpId).execute().body();
 * //the target of head branch is sometimes an alias, so we have to get the id
 * from the url
 * revisions.add(snp.getBranches().getOrDefault("HEAD",snp.getBranches().get(
 * "refs/heads/master")).getTargetUrl().split("/")[6]);
 * latch.countDown();
 * } catch (IOException e) {
 * logger.error("Error while requesting snapshot " + snpId, e);
 * latch.countDown();
 * }catch (NullPointerException e) {
 * logger.
 * error("Error while requesting snapshot, no HEAD or refs/heads/master branch "
 * , e);
 * latch.countDown();
 * }
 * }).start();
 * 
 * });
 */
