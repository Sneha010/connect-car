package com.connectcar.webhook;

import jdk.nashorn.api.scripting.JSObject;

import java.util.HashMap;

/**
 * This class holds the context data which needs to be passed to conversations.
 *
 * Created by Piyush Agarwal on 1/9/17.
 */
public class ContextData {

    private String name;

    private int lifespan;

    private HashMap<String, String> parameteres;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifespan() {
        return lifespan;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }

    public HashMap<String, String> getParameteres() {
        return parameteres;
    }

    public void setParameteres(HashMap<String, String> parameteres) {
        this.parameteres = parameteres;
    }
}
