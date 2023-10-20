package fr.inria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Branch {
    private String target;
    @JsonProperty("target_type")
    private String targetType;//if "alias" target cannot be used to get the swhId of the revision
    @JsonProperty("target_url")
    private String targetUrl;


    public String getTarget() {
        return target;
    }
    public void setTarget(String target) {
        this.target = target;
    }
    public String getTargetType() {
        return targetType;
    }
    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }
    public String getTargetUrl() {
        return targetUrl;
    }
    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }
    @Override
    public String toString() {
        return "Branch [target=" + target + ", targetType=" + targetType + ", targetUrl=" + targetUrl + "]";
    }

    

    
}
