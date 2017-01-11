package com.connectcar.processor;

import com.connectcar.datastore.FileStorage;
import com.connectcar.webhook.WebhookResponse;
import com.google.gson.Gson;

/**
 * Created by Piyush Agarwal on 1/8/17.
 */
public class WebhookResponseHandler {

    private ActionsOnCar actionsOnCar;

    private WebhookResponse webhookResponse;

    public enum ActionsOnCar {

        THERMOSTAT_ON(1), THERMOSTAT_OFF(2), START_MUSIC(3), STOP_MUSIC(4), WELCOME_MESSAGE(5), SORRY(0);

        private int action;

        private String deviceName;

        ActionsOnCar(int action) {

            this.action = action;
        }

        public int getAction() {
            return action;
        }

        public ActionsOnCar setDeviceName(String deviceName) {

            this.deviceName = deviceName;

            return this;

        }

        public String getDeviceName() {
            return deviceName;
        }
    }


    public WebhookResponseHandler(ActionsOnCar actionsOnCar) {
        this.actionsOnCar = actionsOnCar;
    }


    public WebhookResponse buildResponseForAI() {

        String speech, displayText;

        switch (actionsOnCar) {

            case THERMOSTAT_ON:

                speech = Speeches.THERMOSTAT_ON_SPEECH;
                displayText = Speeches.THERMOSTAT_ON_SPEECH;

                break;

            case THERMOSTAT_OFF:

                speech = Speeches.THERMOSTAT_OFF_SPEECH;
                displayText = Speeches.THERMOSTAT_OFF_SPEECH;

                break;

            case START_MUSIC:

                speech = Speeches.MUSIC_ON_SPEECH;
                displayText = Speeches.MUSIC_ON_SPEECH;

                break;

            case STOP_MUSIC:

                speech = Speeches.MUSIC_OFF_SPEECH;
                displayText = Speeches.MUSIC_OFF_SPEECH;

                break;

            default:

                speech = Speeches.SORRY_COULD_NOT_UNDERSTAND;
                displayText = Speeches.SORRY_COULD_NOT_UNDERSTAND;


        }


        WebhookResponse webhookResponse = new WebhookResponse.Builder()
                .speech(personalizedMySpeech(speech))
                .displayText(personalizedMySpeech(displayText))
                .expectUserResponse(false)
                .isSSML(false)
                .build();

        this.webhookResponse = webhookResponse;

        return webhookResponse;


    }

    private String personalizedMySpeech(String speech) {

        return speech.replaceAll("<user>", FileStorage.getUserInfo().getName()).replaceAll("<device>",
                actionsOnCar.getDeviceName());


    }

    public ActionsOnCar getActionsOnCar() {
        return actionsOnCar;
    }



}
