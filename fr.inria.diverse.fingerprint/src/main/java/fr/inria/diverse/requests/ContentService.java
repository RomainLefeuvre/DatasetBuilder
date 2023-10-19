package fr.inria.diverse.requests;


import retrofit2.http.GET;
import retrofit2.http.Path;
import okhttp3.ResponseBody;
import retrofit2.Call;

public interface ContentService {

    /**
     * request a raw file from its sha1_git id(note it is the target attribute of a
     * file)
     * 
     * @param target the sha1_git id
     * @return a response containing the raw file
     */
    @GET("content/sha1_git:{target}/raw")
    Call<ResponseBody> requestRaw(@Path("target") String target);

    /**
     * Get the object corresponding to the SWHID in raw form.
     * 
     * @param swhid
     * @return a response containing the raw file
     */
    @GET("raw/{swhid}")
    Call<ResponseBody> requestRawFromSwhid(@Path("swhid") String swhid);

}
