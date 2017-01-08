
package com.connectcar.webhook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RawInput {

    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("input_type")
    @Expose
    private Integer inputType;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

}
