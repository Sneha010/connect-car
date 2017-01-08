
package com.connectcar.webhook;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("speech")
    @Expose
    private String speech;
    @SerializedName("fulfillment")
    @Expose
    private Fulfillment fulfillment;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("resolvedQuery")
    @Expose
    private String resolvedQuery;
    @SerializedName("actionIncomplete")
    @Expose
    private Boolean actionIncomplete;
    @SerializedName("contexts")
    @Expose
    private List<Context> contexts = null;
    @SerializedName("parameters")
    @Expose
    private Parameters_ parameters;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public Fulfillment getFulfillment() {
        return fulfillment;
    }

    public void setFulfillment(Fulfillment fulfillment) {
        this.fulfillment = fulfillment;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getResolvedQuery() {
        return resolvedQuery;
    }

    public void setResolvedQuery(String resolvedQuery) {
        this.resolvedQuery = resolvedQuery;
    }

    public Boolean getActionIncomplete() {
        return actionIncomplete;
    }

    public void setActionIncomplete(Boolean actionIncomplete) {
        this.actionIncomplete = actionIncomplete;
    }

    public List<Context> getContexts() {
        return contexts;
    }

    public void setContexts(List<Context> contexts) {
        this.contexts = contexts;
    }

    public Parameters_ getParameters() {
        return parameters;
    }

    public void setParameters(Parameters_ parameters) {
        this.parameters = parameters;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

}
