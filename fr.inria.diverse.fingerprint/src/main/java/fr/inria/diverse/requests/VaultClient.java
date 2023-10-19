package fr.inria.diverse.requests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.twitter.chill.Base64.InputStream;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

public class VaultClient {
    static Logger logger = LogManager.getLogger(VaultClient.class);
    VaultService proxy;

    public VaultClient() {
        UriBuilder FULL_PATH = UriBuilder.fromPath("https://archive.softwareheritage.org");
        ResteasyClient client = (ResteasyClient) ClientBuilder.newClient();
        ResteasyWebTarget target = client.target(FULL_PATH);
        proxy = target.proxy(VaultService.class);
    }

    /**
     * Request the cooking of a bundle for a certain software heritage id.
     * @param bundleType the type of bundle to be created (either flat, gitfast or git-bare)
     * @param swhId the software heritage id
     * @return a response containing the current state of cooking
     */
    public CookingStatus requestCooking(String bundleType,String swhId) {
        return proxy.startCooking(bundleType,swhId);
    }

    /**
     * Receives the cooked bundle if it exists. 
     * @param bundleType the type of bundle to be created
     * @param swhId the software heritage id
     * @param path the path to save the file
     * @return 
     */
    public void ReceiveCooked(String bundleType,String swhId, String filePath) {
        Response response = proxy.receivedCooked(bundleType,swhId);
        InputStream inputStream = response.readEntity(InputStream.class);
        Path path = Paths.get(filePath);
        try {
            Files.copy(inputStream, path);
        } catch (IOException e) {

            e.printStackTrace();
        }
        return ;
    }

}
