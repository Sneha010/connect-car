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
    private static String WELCOME = "input.welcome";

    private static final String DEVICE_TYPE_THERMO = "thermostat";
    private static final String DEVICE_TYPE_HEATER = "heater";
    private static final String DEVICE_TYPE_MUSIC = "music player";
    private static final String DEVICE_TYPE_GAANE = "gaane";


    @Override
    public WebhookResponseHandler.ActionsOnCar processRequest(String requestData) {

        WebhookResponseHandler.ActionsOnCar actionsOnCar;

        String action = getWebhookRequest(requestData).getResult().getAction();

        String deviceType = getWebhookRequest(requestData).getResult().getParameters().getDeviceType();

        String actionOnDevice = getWebhookRequest(requestData).getResult().getParameters().getSwitch();



        if (action.equalsIgnoreCase(THERMO_ON)) {

            actionsOnCar = THERMOSTAT_ON;

        } else if (action.equalsIgnoreCase(THERMO_OFF)) {

            actionsOnCar = THERMOSTAT_OFF;

        } else if (action.equalsIgnoreCase(MUSIC_ON)) {

            actionsOnCar = START_MUSIC;

        } else if (action.equalsIgnoreCase(MUSIC_OFF)) {

            actionsOnCar = STOP_MUSIC;

        }else if (action.equalsIgnoreCase(WELCOME)){

            actionsOnCar = WELCOME_MESSAGE;

        } else {

            actionsOnCar = SORRY;
        }

        return actionsOnCar.setDeviceName(deviceType);

    }
}
