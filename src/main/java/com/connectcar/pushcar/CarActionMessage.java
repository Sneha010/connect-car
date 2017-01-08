package com.connectcar.pushcar;

import com.connectcar.webhook.ResponseActions;

/**
 * Created by Piyush Agarwal on 1/8/17.
 *
 * This class will create an action message which will be sent to car.
 *
 */
public class CarActionMessage {

    private ResponseActions.ActionOnGoogle actionOnGoogle;

    private String message;


    public ResponseActions.ActionOnGoogle getActionOnGoogle() {
        return actionOnGoogle;
    }

    public void setActionOnGoogle(ResponseActions.ActionOnGoogle actionOnGoogle) {
        this.actionOnGoogle = actionOnGoogle;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
