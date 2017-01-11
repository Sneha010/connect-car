package com.connectcar;

import com.connectcar.dao.DeviceInfo;
import com.connectcar.dao.Response;
import com.connectcar.dao.User;
import com.connectcar.datastore.FileStorage;
import com.connectcar.processor.WebhookResponseHandler;
import com.connectcar.processor.WebhookRequestProcessor;
import com.connectcar.pushcar.CarActionMessage;
import com.connectcar.pushcar.CarMessageSender;
import com.connectcar.webhook.*;
import com.google.android.gcm.server.Result;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import javax.ws.rs.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Piyush Agarwal on 1/6/17.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/ai")
public class AIWebService {
    // The Java method will process HTTP GET requests


    private static final String API_KEY="AIzaSyChuYzwk5vHk4tOXWj_i3S6CXx8w6BYD2k";

    @POST
    @Path("/user")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    @Consumes("application/json")
    public String createUser(String data) throws IOException {
        // Return some cliched textual content

        System.out.println("User data received = [" + data + "]");

        Response response = FileStorage.storeUserInfo(data);

        System.out.println("Sending response = " + response);

        return response.toString();
    }


    @GET
    @Path("/user")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public String getUser() throws IOException {
        // Return some cliched textual content


        User response = FileStorage.getUserInfo();

        System.out.println("Sending response = " + response.getName());

        return response.getName();
    }


    @POST
    @Path("/device")
    @Produces("application/json")
    @Consumes("application/json")
    public String registerDevice(String registerData) {

        System.out.println("Device data received = [" + registerData + "]");

        Response response = FileStorage.storeDeviceInfo(registerData);

        System.out.println("Sending response = " + response);

        return response.toString();

    }

    @GET
    @Path("/device")
    @Produces("application/json")
    public String getDevice() {


        DeviceInfo response = FileStorage.getDeviceInfo();

        System.out.println("Sending response = " + response.getDevicePushToken());

        return response.getDevicePushToken();

    }


    @POST
    @Path("/actions")
    @Produces("application/json")
    public String actionResponse(String requestData) {

        System.out.println("Request Data : " + requestData);

        WebhookRequestProcessor processor = new WebhookRequestProcessor();

        WebhookResponseHandler.ActionsOnCar actionsOnCar = processor.processRequest(requestData);

        System.out.println("Action found " + actionsOnCar );


        WebhookResponseHandler webhookResponseHandler = new WebhookResponseHandler(actionsOnCar);

        System.out.println("Action detected " + webhookResponseHandler.getActionsOnCar().getAction());

        WebhookResponse response = webhookResponseHandler.buildResponseForAI();

        sendNotificationToCar(actionsOnCar, response);

        System.out.println("Sending Response to api.ai " + response.buildJsonOfResponse());

        return response.buildJsonOfResponse();

    }


    private void sendNotificationToCar(WebhookResponseHandler.ActionsOnCar actionsOnCar, WebhookResponse response) {
        CarMessageSender sender = CarMessageSender.getInstance(API_KEY);

        CarActionMessage message = new CarActionMessage();
        message.setActionsOnCar(actionsOnCar);
        message.setMessage(response.getDisplayText());

        System.out.println("Sending message to "+FileStorage.getDeviceInfo().getDevicePushToken());

        Result result = sender.sendMessageToCar(FileStorage.getDeviceInfo().getDevicePushToken(), message);

        System.out.println("Send message to car result = " + result);
    }


}


