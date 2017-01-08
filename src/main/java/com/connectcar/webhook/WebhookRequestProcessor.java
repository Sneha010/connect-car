package com.connectcar.webhook;


import static com.connectcar.webhook.ResponseActions.ActionOnGoogle.*;

/**
 * Created by Piyush Agarwal on 1/8/17.
 *
 * This class takes the data coming from api.ai and process it.
 * It intimates the car also for aproperiate action.
 */
public class WebhookRequestProcessor implements RequestProcessor {

    private static String THERMO_ON = "thermostat-on";
    private static String THERMO_OFF = "thermostat-off";
    private static String MUSIC_ON = "music-on";
    private static String MUSIC_OFF = "music-off";


    @Override
    public ResponseActions processRequest(WebhookRequest request) {

        ResponseActions.ActionOnGoogle actionOnGoogle;

        String action = request.getResult().getAction();

        if (action.equalsIgnoreCase(THERMO_ON)) {

            actionOnGoogle = THERMOSTAT_ON;

        } else if (action.equalsIgnoreCase(THERMO_OFF)) {

            actionOnGoogle = THERMOSTAT_OFF;

        } else if (action.equalsIgnoreCase(MUSIC_ON)) {

            actionOnGoogle = START_MUSIC;

        } else if (action.equalsIgnoreCase(MUSIC_OFF)) {

            actionOnGoogle = STOP_MUSIC;
        }else {

            actionOnGoogle = SORRY;
        }

        return new ResponseActions(actionOnGoogle);

    }
}
