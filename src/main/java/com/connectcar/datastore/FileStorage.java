package com.connectcar.datastore;

import com.connectcar.dao.DeviceInfo;
import com.connectcar.dao.Response;
import com.connectcar.dao.User;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Piyush Agarwal(559339) on 1/9/17.
 */
public class FileStorage {

    private static final String filePath = new File("").getAbsolutePath();

    private static final String USER_FILE = "/user_info.txt";

    private static final String DEVICE_FILE = "/user_info.txt";

    public static Response storeUserInfo(String userData) {

        Response response = new Response();

        try {
            File textFile = new File(filePath + USER_FILE);

            if (!textFile.exists()) {

                textFile.createNewFile();

            }

            FileUtils.writeStringToFile(textFile, userData);

            response.setStatus_code(200);

            response.setMessage("Success");

        } catch (IOException e) {

            response.setStatus_code(500);

            response.setMessage("Failed " + e.getMessage());
        }


        return response;

    }

    public static User getUserInfo() {

        User user = null;

        try {
            File textFile = new File(filePath + USER_FILE);

            String userInfo = FileUtils.readFileToString(textFile);

            user = new Gson().fromJson(userInfo, User.class);

        } catch (IOException e) {

            System.out.println("Error in storing user information " + e.getMessage());

        }

        return user;
    }


    public static Response storeDeviceInfo(String deviceInfo) {

        Response response = new Response();

        try {
            File textFile = new File(filePath + DEVICE_FILE);

            if (!textFile.exists()) {

                System.out.println("Creating file for storing device info");

                textFile.createNewFile();

            }

            System.out.println("File already present writing device info to file");

            FileUtils.writeStringToFile(textFile, deviceInfo);

            response.setStatus_code(200);

            response.setMessage("Success");


        } catch (IOException e) {

            response.setStatus_code(500);

            response.setMessage("Failed " + e.getMessage());

            System.out.println("Error in storing device information " + e.getMessage());

        }

        return response;

    }


    public static DeviceInfo getDeviceInfo() {

        DeviceInfo deviceInfo = null;

        try {
            File textFile = new File(filePath + DEVICE_FILE);

            String userInfo = FileUtils.readFileToString(textFile);

            deviceInfo = new Gson().fromJson(userInfo, DeviceInfo.class);

        } catch (IOException e) {

            System.out.println("Error in storing user information " + e.getMessage());

        }

        return deviceInfo;

    }


}
