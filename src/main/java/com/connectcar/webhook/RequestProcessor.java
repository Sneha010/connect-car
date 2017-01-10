package com.connectcar.webhook;

import com.google.gson.Gson;

/**
 * Created by Piyush Agarwal on 1/9/17.
 */
public abstract class RequestProcessor<T> {


    public abstract T processRequest(String request);


    protected WebhookRequest getWebhookRequest(String requestData) {

        WebhookRequest request = new Gson().fromJson(requestData, WebhookRequest.class);

        return request;

    }

}
