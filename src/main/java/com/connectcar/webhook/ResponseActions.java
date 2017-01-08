package com.connectcar.webhook;

import java.util.ArrayList;

/**
 * Created by Piyush Agarwal on 1/8/17.
 */
public class ResponseActions {

    private static String THEROSTAT_ON_SPEECH = " Ok I am turning on your thermostat in car";
    private static String THEROSTAT_OFF_SPEECH = " Ok I am turning off your thermostat in car";
    private static String MUSIC_OFF_SPEECH = " Ok I am turning on your music player. Enjoy";
    private static String MUSIC_ON_SPEECH = " Ok I am turning off your music player. Enjoy";
    private static String SORRY_COULD_NOT_UNDERSTAND = "Sorry, I could not understand what you want to say. Try again.";


    public enum ActionOnGoogle {

        THERMOSTAT_ON(1), THERMOSTAT_OFF(2), START_MUSIC(3), STOP_MUSIC(4), SORRY(0);

        private int action;

        ActionOnGoogle(int action) {

            this.action = action;
        }

        public int getAction() {
            return action;
        }
    }

    public static WebhookResponse getJsonResponse(ActionOnGoogle actionOnGoogle) {

        String speech, displayText;

        Google google = new Google();

        PermissionsRequest permissionsRequest = new PermissionsRequest();

        permissionsRequest.setOptContext("");

        permissionsRequest.setPermissions(new ArrayList<String>());

        google.setExpectUserResponse(true);
        google.setIsSsml(true);
        google.setPermissionsRequest(new PermissionsRequest());

        Data data = new Data();
        data.setGoogle(google);

        switch (actionOnGoogle) {

            case THERMOSTAT_ON:

                speech = THEROSTAT_ON_SPEECH;
                displayText = THEROSTAT_OFF_SPEECH;

                break;

            case THERMOSTAT_OFF:

                speech = THEROSTAT_OFF_SPEECH;
                displayText = THEROSTAT_OFF_SPEECH;

                break;

            case START_MUSIC:

                speech = MUSIC_ON_SPEECH;
                displayText = MUSIC_ON_SPEECH;

                break;

            case STOP_MUSIC:

                speech = MUSIC_OFF_SPEECH;
                displayText = MUSIC_OFF_SPEECH;

                break;

            default:

                speech = SORRY_COULD_NOT_UNDERSTAND;
                displayText = SORRY_COULD_NOT_UNDERSTAND;


        }


        return new WebhookResponse(speech, displayText, data, new ArrayList<>());


    }

}
