package com.connectcar;

import com.connectcar.dao.User;
import com.google.gson.Gson;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

/**
 * Created by dksc102950 on 1/6/17.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/ai")
public class AIWebService {
    // The Java method will process HTTP GET requests
    @POST
    @Path("/login")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    @Consumes("application/json")
    public String getClichedMessage(String data) {
        // Return some cliched textual content

        User user = new Gson().fromJson(data, User.class);

        return user.getUserName();
    }

    @POST
    @Path("/registerdevice")
    @Produces("application/json")
    public String registerDevice(String registerData){



        return null;


    }




}
