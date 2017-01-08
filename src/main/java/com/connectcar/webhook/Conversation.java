
package com.connectcar.webhook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Conversation {

    @SerializedName("conversation_token")
    @Expose
    private String conversationToken;
    @SerializedName("conversation_id")
    @Expose
    private String conversationId;
    @SerializedName("type")
    @Expose
    private Integer type;

    public String getConversationToken() {
        return conversationToken;
    }

    public void setConversationToken(String conversationToken) {
        this.conversationToken = conversationToken;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
