
package com.connectcar.webhook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 *
 * Created by Piyush Agarwal on 1/9/17.
 *
 */

public class Argument {

    @SerializedName("raw_text")
    @Expose
    private String rawText;
    @SerializedName("text_value")
    @Expose
    private String textValue;
    @SerializedName("name")
    @Expose
    private String name;

    public String getRawText() {
        return rawText;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
