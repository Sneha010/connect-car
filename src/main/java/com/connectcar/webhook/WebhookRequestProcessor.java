package com.connectcar.webhook;

/**
 * Created by dksc102950 on 1/8/17.
 *
 * This class takes the data coming from api.ai and process it.
 * It intimates the car also for aproperiate action.
 */
public class WebhookRequestProcessor {

    private static String THERMO_ON = "thermostate-on";
    private static String THERMO_OFF = "thermostate-off";
    private static String MUSIC_ON = "music-on";
    private static String MUSIC_OFF = "music-off";

    public static ResponseActions.ActionOnGoogle processRequest(WebhookRequest request) {

        String action = request.getResult().getAction();

        if (action.equalsIgnoreCase(THERMO_ON)) {

            return ResponseActions.ActionOnGoogle.THERMOSTAT_ON;
        } else if (action.equalsIgnoreCase(THERMO_OFF)) {

            return ResponseActions.ActionOnGoogle.THERMOSTAT_OFF;
        } else if (action.equalsIgnoreCase(MUSIC_ON)) {

            return ResponseActions.ActionOnGoogle.START_MUSIC;
        } else if (action.equalsIgnoreCase(MUSIC_OFF)) {

            return ResponseActions.ActionOnGoogle.STOP_MUSIC;
        }


        return ResponseActions.ActionOnGoogle.SORRY;

    }
}
