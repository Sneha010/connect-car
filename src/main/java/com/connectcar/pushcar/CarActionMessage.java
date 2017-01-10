package com.connectcar.pushcar;

import com.connectcar.processor.WebhookResponseHandler;

/**
 * Created by Piyush Agarwal on 1/8/17.
 *
 * This class will create an action message which will be sent to car.
 *
 */
public class CarActionMessage {

    private WebhookResponseHandler.ActionsOnCar actionsOnCar;

    private String message;


    public WebhookResponseHandler.ActionsOnCar getActionsOnCar() {
        return actionsOnCar;
    }

    public void setActionsOnCar(WebhookResponseHandler.ActionsOnCar actionsOnCar) {
        this.actionsOnCar = actionsOnCar;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
