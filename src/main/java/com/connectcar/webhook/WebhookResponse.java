
package com.connectcar.webhook;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class WebhookResponse {

    @SerializedName("speech")
    @Expose
    private String speech;
    @SerializedName("displayText")
    @Expose
    private String displayText;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("contextOut")
    @Expose
    private List<ContextData> contextOut = null;


    private WebhookResponse(String speech, String displayText, Data data, List<ContextData> contextOut) {
        this.speech = speech;
        this.displayText = displayText;
        this.data = data;
        this.contextOut = contextOut;
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public List<ContextData> getContextOut() {
        return contextOut;
    }

    public void setContextOut(List<ContextData> contextOut) {
        this.contextOut = contextOut;
    }


    public static class Builder {

        private String speech;

        private  String displayText;

        private boolean expectUserResponse;

        private boolean isSSML;

        private PermissionsRequest permissionsRequest;

        private List<ContextData> contextOut;


        /**
         *
         * You want your Assistance to respond, what it should response please pass that string here.
         *
         * Better to be short and clear about the action.
         *
         * @param speech
         * @return
         */
        public Builder speech(String speech){

            this.speech = speech;

            return this;

        }

        /**
         *
         * I am mandatory, Give me a readable String. I will be visible to user on screen.
         *
         * @param displayText
         * @return
         */

        public Builder displayText(String displayText) {

            this.displayText = displayText;

            return this;
        }


        /**
         *
         * Do you need a conversation with Home, set me true than.
         *
         * @param expectUserResponse
         * @return
         */

        public Builder expectUserResponse(boolean expectUserResponse) {

            this.expectUserResponse = expectUserResponse;

            return this;

        }


        /**
         * Set this true if the speech tage has SSML language
         *
         * To know more about SSML please check https://www.w3.org/TR/speech-synthesis
         *
         * @param isSSML
         * @return
         */
        public Builder isSSML(boolean isSSML) {

            this.isSSML = isSSML;

            return this;

        }

        /**
         *
         * Set this only if you require any permission else skip this field
         *
         * @param permissionsRequest
         * @return
         */
        public Builder permissionsRequest(PermissionsRequest permissionsRequest) {

            this.permissionsRequest = permissionsRequest;

            return this;
        }


        /**
         *
         * If you want to pass something to next request in case of conversation you can pass
         *
         * @param contextOut
         * @return
         */
        public Builder conetxtsData(List<ContextData> contextOut) {

            this.contextOut = contextOut;

            return this;
        }


        public WebhookResponse build() {

            if (speech == null || speech.length() == 0) {

                throw new IllegalArgumentException("You must pass the speech response.");
            } else if (displayText == null || displayText.length() == 0) {

                throw new IllegalArgumentException("You must set the display text");
            } else{

                Google google = new Google();

                google.setPermissionsRequest(this.permissionsRequest);

                google.setIsSsml(this.isSSML);

                google.setExpectUserResponse(this.expectUserResponse);

                Data data = new Data();
                data.setGoogle(google);

                return new WebhookResponse(speech, displayText, data, this.contextOut);

            }


        }


    }

    public String buildJsonOfResponse() {

        return new Gson().toJson(this, WebhookResponse.class);

    }

}
