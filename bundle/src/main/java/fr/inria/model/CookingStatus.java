package fr.inria.model;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CookingStatus {
    private int id;
    private String fetch_url;
    private String swhid;
    private String progress_message;
    private Status status;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public enum Status {
        NEW,
        PENDING,
        DONE,
        FAILED;

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
