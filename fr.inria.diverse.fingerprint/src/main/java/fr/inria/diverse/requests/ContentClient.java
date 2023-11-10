package fr.inria.diverse.requests;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import okhttp3.ResponseBody;
import retrofit2.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import okhttp3.Request;

public class ContentClient {
    static Logger logger = LogManager.getLogger(ContentClient.class);
    ContentService contentService;

    public ContentClient() {

        // create the retrofit object //
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add the authorization header to the request
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("Authorization",
                                "Bearer eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJhMTMxYTQ1My1hM2IyLTQwMTUtODQ2Ny05MzAyZjk3MTFkOGEifQ.eyJpYXQiOjE2OTY5MjkxOTgsImp0aSI6IjE3NzY2ZmZkLWNhOGEtNGRjYy1hMGFiLTVmMDVjMGU3MDQwYSIsImlzcyI6Imh0dHBzOi8vYXV0aC5zb2Z0d2FyZWhlcml0YWdlLm9yZy9hdXRoL3JlYWxtcy9Tb2Z0d2FyZUhlcml0YWdlIiwiYXVkIjoiaHR0cHM6Ly9hdXRoLnNvZnR3YXJlaGVyaXRhZ2Uub3JnL2F1dGgvcmVhbG1zL1NvZnR3YXJlSGVyaXRhZ2UiLCJzdWIiOiIwZmUxYWU4MS1mMWE0LTQzM2MtOTYxZS1kN2M5ZjczYWY4NTkiLCJ0eXAiOiJPZmZsaW5lIiwiYXpwIjoic3doLXdlYiIsInNlc3Npb25fc3RhdGUiOiJlOWEzMDk2Mi1mMWVlLTQyZmEtOGZmYi03MThmMDg1YTY4YjMiLCJzY29wZSI6Im9wZW5pZCBvZmZsaW5lX2FjY2VzcyBwcm9maWxlIGVtYWlsIn0.X_4M4ZwplWTc_aSUV80zt7JyXc4CvImI_dpP5zoEs9Y")
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });
        OkHttpClient swhClient = httpClient.build();

        Retrofit swhRetrofit = new Retrofit.Builder()
                .baseUrl("https://archive.softwareheritage.org/api/1/")
                .client(swhClient)
                .build();
        contentService = swhRetrofit.create(ContentService.class);

    }

    /**
     *  Checks if the content of a file contains a given string
     * @param target the sha1_git id (i.e. for content, it is the last part of the swhid) of the file
     * @param searchString the string to search for in the file
     * @return true if the file contains the string, false otherwise
     */
    public boolean ReceiveContentContains(String target, String searchString) {
        Call<ResponseBody> call = contentService.requestRaw(target);
        retrofit2.Response<ResponseBody> response;
        try {
            response = call.execute();
            logger.info("address"+call.request().url());
            logger.info("searching for string '"+searchString+"' in"+target);
            if (response.isSuccessful()) {
                ResponseBody responseBody = response.body();
                byte[] bytes = responseBody.bytes();
                String content = new String(bytes, StandardCharsets.UTF_8);
                return content.contains(searchString);
            }else{
                logger.warn("response unsuccessful message"+ response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * receives a byte array containing the raw file or null if the file does not
     * exist
     * 
     * @apiNote this method might not work for all swhids i.e. it might not work for
     *          swhids that are not content
     * @param searchString the string to search for in the file
     * @param swhid the swhid of the requested file
     * @return true if the file contains the string, false otherwise
     */
    public boolean ReceiveContentContainsWithSwhId(String swhid, String searchString) {
        Call<ResponseBody> call = contentService.requestRawFromSwhid(swhid);
        retrofit2.Response<ResponseBody> response;
        try {
            response = call.execute();
            if (response.isSuccessful()) {
                ResponseBody responseBody = response.body();
                byte[] bytes = responseBody.bytes();
                String content = new String(bytes, StandardCharsets.UTF_8);
                return content.contains(searchString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

/**
 * Checks if the content of a file matches a given regex pattern
 * @param target the sha1_git id (i.e. for content, it is the swhid) of the file
 * @param pattern the regex pattern to match
 * @return true if the file matches the pattern, false otherwise
 * To create a pattern, use {@code Pattern.compile("regex")}
 */
public boolean ReceiveContentRegex(String target, Pattern pattern) {
        Call<ResponseBody> call = contentService.requestRaw(target);
        retrofit2.Response<ResponseBody> response;
        try {
            response = call.execute();
            if (response.isSuccessful()) {
                ResponseBody responseBody = response.body();
                byte[] bytes = responseBody.bytes();
                String content = new String(bytes, StandardCharsets.UTF_8);
                return pattern.matcher(content).find();
            }else{
                logger.warn("response unsuccessful message"+ response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
