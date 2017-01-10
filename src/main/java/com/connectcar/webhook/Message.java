
package com.connectcar.webhook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * Created by Piyush Agarwal on 1/9/17.
 */
public class Message {

    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("speech")
    @Expose
    private String speech;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

}
