
package com.connectcar.webhook;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("match")
    @Expose
    private List<String> match = null;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("event")
    @Expose
    private String event;
    @SerializedName("team")
    @Expose
    private String team;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("channel")
    @Expose
    private String channel;
    @SerializedName("ts")
    @Expose
    private String ts;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getMatch() {
        return match;
    }

    public void setMatch(List<String> match) {
        this.match = match;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

}
