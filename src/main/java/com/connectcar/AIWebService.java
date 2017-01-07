package com.connectcar;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

/**
 * Created by dksc102950 on 1/6/17.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class AIWebService {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World New";
    }


}
