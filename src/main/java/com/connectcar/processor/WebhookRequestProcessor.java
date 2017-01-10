package com.connectcar.processor;


import com.connectcar.webhook.RequestProcessor;
import com.connectcar.webhook.WebhookRequest;

import static com.connectcar.processor.WebhookResponseHandler.ActionsOnCar.*;

/**
 * Created by Piyush Agarwal on 1/8/17.
 *
 * This is a class takes the data coming from api.ai and process it.
 *
 * You can create your own request processors.
 *
 *
 *
 */


public class WebhookRequestProcessor extends RequestProcessor<WebhookResponseHandler.ActionsOnCar> {

    private static String THERMO_ON = "thermostat-on";
    private static String THERMO_OFF = "thermostat-off";
    private static String MUSIC_ON = "music-on";
    private static String MUSIC_OFF = "music-off";


    @Override
    public WebhookResponseHandler.ActionsOnCar processRequest(String requestData) {

        WebhookResponseHandler.ActionsOnCar actionsOnCar;

        String action = getWebhookRequest(requestData).getResult().getAction();

        if (action.equalsIgnoreCase(THERMO_ON)) {

            actionsOnCar = THERMOSTAT_ON;

        } else if (action.equalsIgnoreCase(THERMO_OFF)) {

            actionsOnCar = THERMOSTAT_OFF;

        } else if (action.equalsIgnoreCase(MUSIC_ON)) {

            actionsOnCar = START_MUSIC;

        } else if (action.equalsIgnoreCase(MUSIC_OFF)) {

            actionsOnCar = STOP_MUSIC;

        }else {

            actionsOnCar = SORRY;
        }

        return actionsOnCar;

    }
}
