
package com.connectcar.webhook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WebhookRequest {

    @SerializedName("originalRequest")
    @Expose
    private OriginalRequest originalRequest;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("sessionId")
    @Expose
    private String sessionId;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("status")
    @Expose
    private Status status;

    public OriginalRequest getOriginalRequest() {
        return originalRequest;
    }

    public void setOriginalRequest(OriginalRequest originalRequest) {
        this.originalRequest = originalRequest;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
