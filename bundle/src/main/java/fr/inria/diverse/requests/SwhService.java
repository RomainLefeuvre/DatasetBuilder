package fr.inria.diverse.requests;

import fr.inria.model.CookingStatus;
import fr.inria.model.Snapshot;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SwhService {

    /**
     * TODO change String to Enum BundleType with custom serializer
     * request the cooking of a bundle for a certain software heritage id.
     * 
     * @param bundleType the type of bundle to be created
     * @param swhId      the software heritage id
     * @return a response contianing the current state of cooking
     */
    @POST("vault/{bundletype}/{swhId}/")
    Call<CookingStatus> startCooking(@Path("bundletype") String bundleType, @Path("swhId") String swhId);

    /**
     * TODO change String to Enum BundleType with custom serializer
     * 
     * @param bundleType the type of bundle to be created
     * @param swhId      the software heritage id
     */
    @GET("vault/{bundletype}/{swhId}/raw")
    @Headers("Content-Type:application/octet-stream")
    Call<ResponseBody> receivedCooked(@Path("bundletype") String bundleType, @Path("swhId") String swhId);

    /**
     * requests for a snapshot from its id
     * 
     * @param snapshotId the id of the snapshot
     * @return the response body of the request
     */
    @GET("snapshot/{snapshot_id}")
    Call<Snapshot> requestSnapshot(@Path("snapshot_id") String snapshotId);

}
