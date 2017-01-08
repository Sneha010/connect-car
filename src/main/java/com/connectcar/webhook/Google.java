
package com.connectcar.webhook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Google {

    @SerializedName("expect_user_response")
    @Expose
    private Boolean expectUserResponse;
    @SerializedName("is_ssml")
    @Expose
    private Boolean isSsml;
    @SerializedName("permissions_request")
    @Expose
    private PermissionsRequest permissionsRequest;

    public Boolean getExpectUserResponse() {
        return expectUserResponse;
    }

    public void setExpectUserResponse(Boolean expectUserResponse) {
        this.expectUserResponse = expectUserResponse;
    }

    public Boolean getIsSsml() {
        return isSsml;
    }

    public void setIsSsml(Boolean isSsml) {
        this.isSsml = isSsml;
    }

    public PermissionsRequest getPermissionsRequest() {
        return permissionsRequest;
    }

    public void setPermissionsRequest(PermissionsRequest permissionsRequest) {
        this.permissionsRequest = permissionsRequest;
    }

}
