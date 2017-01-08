
package com.connectcar.webhook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameters {

    @SerializedName("device-type")
    @Expose
    private String deviceType;
    @SerializedName("switch")
    @Expose
    private String _switch;

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getSwitch() {
        return _switch;
    }

    public void setSwitch(String _switch) {
        this._switch = _switch;
    }

}
