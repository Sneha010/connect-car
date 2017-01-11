package com.connectcar.pushcar;

import com.google.android.gcm.server.InvalidRequestException;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

import java.io.IOException;

/**
 * Created by Piyush Agarwal on 1/8/17.
 *
 * This class will process and send an action to car.
 */
public class CarMessageSender {

    private static CarMessageSender instance;

    private String apiKey;

    private static final int RETRIAL = 3;

    private CarMessageSender(String apiKey) {

        this.apiKey = apiKey;

    }


    public static CarMessageSender getInstance(String apiKey) {

        if (instance == null) {

            instance = new CarMessageSender(apiKey);
        }

        return instance;

    }


    public Result sendMessageToCar(String regId, CarActionMessage message) {

        Result result = null;

        try {
            Sender sender = new Sender(apiKey);

            Message pushMessage = new Message.Builder()
                    .addData("actionId", message.getActionsOnCar().toString())
                    .addData("message", message.getMessage())
                    .build();

            result = sender.send(pushMessage, regId, RETRIAL);

            System.out.println("Result for google server = " + result);

        } catch (InvalidRequestException ex) {

            System.out.println("Failed = " + ex.getMessage());


        }  catch (IOException e) {
            System.out.println("Failed = " + e.getMessage());

        }

        return result;

    }
}
