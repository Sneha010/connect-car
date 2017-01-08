
package com.connectcar.webhook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameters {

    @SerializedName("slack_channel")
    @Expose
    private String slackChannel;
    @SerializedName("shipping-zone.original")
    @Expose
    private String shippingZoneOriginal;
    @SerializedName("shipping-zone")
    @Expose
    private String shippingZone;
    @SerializedName("slack_user_id")
    @Expose
    private String slackUserId;

    public String getSlackChannel() {
        return slackChannel;
    }

    public void setSlackChannel(String slackChannel) {
        this.slackChannel = slackChannel;
    }

    public String getShippingZoneOriginal() {
        return shippingZoneOriginal;
    }

    public void setShippingZoneOriginal(String shippingZoneOriginal) {
        this.shippingZoneOriginal = shippingZoneOriginal;
    }

    public String getShippingZone() {
        return shippingZone;
    }

    public void setShippingZone(String shippingZone) {
        this.shippingZone = shippingZone;
    }

    public String getSlackUserId() {
        return slackUserId;
    }

    public void setSlackUserId(String slackUserId) {
        this.slackUserId = slackUserId;
    }

}
