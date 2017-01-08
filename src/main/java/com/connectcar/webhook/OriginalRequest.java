
package com.connectcar.webhook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OriginalRequest {

    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
