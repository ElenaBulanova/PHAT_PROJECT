package com.xask.phat_project.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonBuilderUtil {
    public static String getJson(Object resp){
        GsonBuilder builder = new GsonBuilder();
        Gson response = builder.create();
        return response.toJson(resp);
    }
}
