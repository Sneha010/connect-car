package com.connectcar.utilities;

import com.connectcar.dao.DeviceInfo;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;

/**
 * Created by dksc102950 on 1/7/17.
 */
public class FileDataUtils {

    public static void saveDeviceInfoInFile(String path, DeviceInfo deviceInfo) {

        File file = new File(path+"deviceInfo");

        if (!file.exists()) {
            try {
                file.createNewFile();

                String deviceData = new Gson().toJson(deviceInfo);



            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
