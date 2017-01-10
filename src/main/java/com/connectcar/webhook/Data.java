
package com.connectcar.webhook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * Created by Piyush Agarwal on 1/9/17.
 *
 */
public class Data {

    @SerializedName("google")
    @Expose
    private Google google;

    public Google getGoogle() {
        return google;
    }

    public void setGoogle(Google google) {
        this.google = google;
    }

}
