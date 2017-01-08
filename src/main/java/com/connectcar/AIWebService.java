package com.connectcar;

import com.connectcar.dao.DeviceInfo;
import com.connectcar.dao.User;
import com.connectcar.dao.WebhookResponse;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import java.io.File;
import java.io.IOException;

/**
 * Created by dksc102950 on 1/6/17.
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

        try {
            File textFile = new File(filePath + "device.txt");

            if (!textFile.exists()) {

                textFile.createNewFile();

            }

            FileUtils.writeStringToFile(textFile, registerData);

            dataInFile = FileUtils.readFileToString(textFile);

        } catch (IOException e) {

        }

        DeviceInfo deviceInfo = new Gson().fromJson(dataInFile, DeviceInfo.class);

        return deviceInfo.getDevicePushToken();

    }


    @POST
    @Path("/actions")
    @Produces("application/json")
    public String actionResponse(String requestData){

        WebhookResponse response = new WebhookResponse("Test is sucess",
                "Test is success");


        String responseData = new Gson().toJson(response, WebhookResponse.class);

        return responseData;

    }


}


