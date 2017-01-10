
package com.connectcar.webhook;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * Created by Piyush Agarwal on 1/9/17.
 */
public class Input {

    @SerializedName("arguments")
    @Expose
    private List<Argument> arguments = null;
    @SerializedName("intent")
    @Expose
    private String intent;
    @SerializedName("raw_inputs")
    @Expose
    private List<RawInput> rawInputs = null;

    public List<Argument> getArguments() {
        return arguments;
    }

    public void setArguments(List<Argument> arguments) {
        this.arguments = arguments;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public List<RawInput> getRawInputs() {
        return rawInputs;
    }

    public void setRawInputs(List<RawInput> rawInputs) {
        this.rawInputs = rawInputs;
    }

}
