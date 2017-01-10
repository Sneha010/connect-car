
package com.connectcar.webhook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * Created by Piyush Agarwal on 1/9/17.
 */
public class Metadata {

    @SerializedName("intentId")
    @Expose
    private String intentId;
    @SerializedName("webhookUsed")
    @Expose
    private String webhookUsed;
    @SerializedName("webhookForSlotFillingUsed")
    @Expose
    private String webhookForSlotFillingUsed;
    @SerializedName("intentName")
    @Expose
    private String intentName;

    public String getIntentId() {
        return intentId;
    }

    public void setIntentId(String intentId) {
        this.intentId = intentId;
    }

    public String getWebhookUsed() {
        return webhookUsed;
    }

    public void setWebhookUsed(String webhookUsed) {
        this.webhookUsed = webhookUsed;
    }

    public String getWebhookForSlotFillingUsed() {
        return webhookForSlotFillingUsed;
    }

    public void setWebhookForSlotFillingUsed(String webhookForSlotFillingUsed) {
        this.webhookForSlotFillingUsed = webhookForSlotFillingUsed;
    }

    public String getIntentName() {
        return intentName;
    }

    public void setIntentName(String intentName) {
        this.intentName = intentName;
    }

}
