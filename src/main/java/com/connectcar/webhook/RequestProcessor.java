package com.connectcar.webhook;

/**
 * Created by dksc102950 on 1/8/17.
 */
public interface RequestProcessor {

    ResponseActions processRequest(WebhookRequest request);
}
