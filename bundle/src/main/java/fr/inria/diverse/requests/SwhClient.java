package fr.inria.diverse.requests;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
                            .header("Authorization",
                                    "Bearer " + token)
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                }
            });
        }
        OkHttpClient swhClient = httpClient.build();

        Retrofit swhRetrofit = new Retrofit.Builder()
                .baseUrl("https://archive.softwareheritage.org/api/1/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(swhClient)
                .build();
        swhService = swhRetrofit.create(SwhService.class);

    }

    /**
     * Request the cooking of a bundle for a list pf software heritage id.
     * 
     * @param bundleType the type of bundle to be created (either flat, gitfast or
     *                   git-bare)
     * @param swhId      the software heritage id
     * @return a response containing the current state of cooking
     */
    public List<CookingStatus> requestCooking(String bundleType, List<String> swhId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * TODO
     * Receives the cooked bundle if it exists.
     * 
     * @param bundleType   the type of bundle to be created
     * @param swhId        the software heritage id
     * @param outputFolder the folder where the bundle will be placed
     * @return true if the bundle was received and written, false otherwise
     */
    public boolean DownloadCookedIfReady(String bundleType, String swhId, String outputFolder) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * gets the first revision of every snapshot in the import map
     * 
     * @param importMap the import map
     * @return List containing the ids of the first revision of every snapshot
     */
    public List<String> requestRevisionsFromSwhImportMap(Map<String, List<String>> importMap) {

        List<String> revisions = new LinkedList<>();

        importMap.forEach((k, v) -> {
            v.stream()
                    .map(swhid -> SwhUtils.getSnapShotIdFromSwhId(swhid))
                    .forEach(snpId -> {

                        swhService.requestSnapshot(snpId).enqueue(new Callback<Snapshot>() {

                            @Override
                            public void onResponse(Call<Snapshot> call, retrofit2.Response<Snapshot> response) {
                                revisions.add(response.body().getBranches().get("HEAD").getTarget());
                            }

                            @Override
                            public void onFailure(Call<Snapshot> call, Throwable t) {
                                logger.error("Error while requesting snapshot " + snpId, t);

                            }

                        });

                    });
        });
        return revisions;
    }

}
