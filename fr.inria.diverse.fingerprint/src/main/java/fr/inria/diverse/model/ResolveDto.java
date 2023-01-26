package fr.inria.diverse.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResolveDto implements Serializable {

    private static final long serialVersionUID = 2510115165923976380L;
    private String namespace;
    @JsonProperty("object_type")
    private String objectType;
    @JsonProperty("object_id")
    private String objectID;
    @JsonProperty("browse_url")
    private String browseURL;

    public ResolveDto() {
    }

    public ResolveDto(String namespace, String objectType, String objectID, String browseURL) {
        this.namespace = namespace;
        this.objectType = objectType;
        this.objectID = objectID;
        this.browseURL = browseURL;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getObjectID() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }

    public String getBrowseURL() {
        return browseURL;
    }

    public void setBrowseURL(String browseURL) {
        this.browseURL = browseURL;
    }

    @Override
    public String toString() {
        return "ResolveDto{" +
                "namespace='" + namespace + '\'' +
                ", objectType='" + objectType + '\'' +
                ", objectID='" + objectID + '\'' +
                ", browseURL='" + browseURL + '\'' +
                '}';
    }

    public String getFullHash() {
        return this.browseURL.replace("https://archive.softwareheritage.org/browse/content/", "");
    }
}
