package com.connectcar;

import com.connectcar.dao.DeviceInfo;
import com.connectcar.dao.User;
import com.connectcar.pushcar.CarActionMessage;
import com.connectcar.pushcar.CarMessageSender;
import com.connectcar.webhook.ResponseActions;
import com.connectcar.webhook.WebhookRequest;
import com.connectcar.webhook.WebhookRequestProcessor;
import com.connectcar.webhook.WebhookResponse;
import com.google.android.gcm.server.Result;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import java.io.File;
import java.io.IOException;

/**
 * Created by Piyush Agarwal on 1/6/17.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/ai")
public class AIWebService {
    // The Java method will process HTTP GET requests

    private static final String filePath = new File("").getAbsolutePath();

    @POST
    @Path("/login")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    @Consumes("application/json")
    public String getClichedMessage(String data) throws IOException {
        // Return some cliched textual content

        String dataInFile = "";
        try {
            File textFile = new File(filePath + "userinfo.txt");

            if (!textFile.exists()) {

                textFile.createNewFile();

            }

            FileUtils.writeStringToFile(textFile, data);

            dataInFile = FileUtils.readFileToString(textFile);

        } catch (IOException e) {

        }

        User user = new Gson().fromJson(dataInFile, User.class);

        return user.getUserName();
    }

    @POST
    @Path("/registerdevice")
    @Produces("application/json")
    public String registerDevice(String registerData) {

        String dataInFile = "";

        System.out.println("registerData = [" + registerData + "]");

        try {
            File textFile = new File(filePath + "device.txt");

            if (!textFile.exists()) {

                System.out.println("Creating file for storing device info");

                textFile.createNewFile();

            }

            System.out.println("File already present writing device info to file");

            FileUtils.writeStringToFile(textFile, registerData);

            dataInFile = FileUtils.readFileToString(textFile);

        } catch (IOException e) {

            System.out.println("Error in storing device information " + e.getMessage());

        }

        DeviceInfo deviceInfo = new Gson().fromJson(dataInFile, DeviceInfo.class);

        System.out.println(deviceInfo.toString());

        return deviceInfo.getDevicePushToken();

    }


    @POST
    @Path("/actions")
    @Produces("application/json")
    @Consumes("application/json")
    public String actionResponse(String requestData){

        System.out.println("Request Data : " + requestData);

       /* WebhookRequest request = new Gson().fromJson(requestData, WebhookRequest.class);

        ResponseActions.ActionOnGoogle actionOnGoogle = WebhookRequestProcessor.processRequest(request);

        WebhookResponse response = ResponseActions.getJsonResponse(actionOnGoogle);

        CarMessageSender sender = CarMessageSender.getInstance("");

        CarActionMessage message = new CarActionMessage();
        message.setActionOnGoogle(actionOnGoogle);
        message.setMessage(response.getDisplayText());

        Result result = sender.sendMessageToCar("", message);

        System.out.println("Send message to car result = " + result);

        String responseData = new Gson().toJson(response, WebhookResponse.class);

        System.out.println("Sending Response to api.ai " + responseData);*/

        return requestData;

    }


}


