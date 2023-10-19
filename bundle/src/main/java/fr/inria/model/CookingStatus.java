package fr.inria.model;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;

public class CookingStatus {
    private int id;
    private String fetch_url;
    private String swhid;
    private String progress_message;
    private Status status;

    public enum Status{
        NEW,
        PENDING,
        DONE,
        FAILED
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFetchUrl() {
        return fetch_url;
    }

    public void setFetchUrl(String fetchUrl) {
        this.fetch_url = fetchUrl;
    }

    public String getSwhid() {
        return swhid;
    }

    public void setSwhid(String swhid) {
        this.swhid = swhid;
    }

    public String getProgressMessage() {
        return progress_message;
    }

    public void setProgressMessage(String progressMessage) {
        this.progress_message = progressMessage;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
