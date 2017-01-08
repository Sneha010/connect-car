package com.connectcar.webhook;

/**
 * Created by dksc102950 on 1/8/17.
 *
 * This class takes the data coming from api.ai and process it.
 * It intimates the car also for aproperiate action.
 */
public class WebhookRequestProcessor {

    private static String THERMO_ON = "thermostate-on";

    public static ResponseActions.ActionOnGoogle processRequest(WebhookRequest request) {

        String action = request.getResult().getAction();

        if (action.equalsIgnoreCase(THERMO_ON)) {

            return ResponseActions.ActionOnGoogle.THERMOSTAT_ON;
        }


        return ResponseActions.ActionOnGoogle.SORRY;


    }
}
