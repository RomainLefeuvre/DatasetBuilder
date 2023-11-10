package fr.inria.diverse.requests;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/api/1/vault")
public interface VaultService {

    /**
     * TODO change String to Enum BundleType with custom serializer
     * request the cooking of a bundle for a certain software heritage id.
     * @param bundleType the type of bundle to be created
     * @param swhId the software heritage id 
     * @return a response contianing the current state of cooking
     */
    @POST
    @Path("/{bundletype}/{swhId}")
    CookingStatus startCooking(@PathParam("bundletype")String bundleType ,@PathParam("swhId") String swhId);

    /**
     * TODO change String to Enum BundleType with custom serializer
     * @param bundleType the type of bundle to be created
     * @param swhId the software heritage id 
     */
    @GET
    @Path("/{bundletype}/{swhId}/raw")
    Response receivedCooked(@PathParam("bundletype")String bundleType ,@PathParam("swhId") String swhId);

}
