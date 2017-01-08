
package com.connectcar.webhook;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WebhookResponse {

    @SerializedName("speech")
    @Expose
    private String speech;
    @SerializedName("displayText")
    @Expose
    private String displayText;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("contextOut")
    @Expose
    private List<Object> contextOut = null;


    public WebhookResponse(String speech, String displayText, Data data, List<Object> contextOut) {
        this.speech = speech;
        this.displayText = displayText;
        this.data = data;
        this.contextOut = contextOut;
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public List<Object> getContextOut() {
        return contextOut;
    }

    public void setContextOut(List<Object> contextOut) {
        this.contextOut = contextOut;
    }

}
