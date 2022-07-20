package com.sparkrest.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.ResponseTransformer;

public class JsonResponseTransformer implements ResponseTransformer {

    private final Gson gson = new GsonBuilder().create();

    @Override
    public String render(Object o) throws Exception {
        return gson.toJson(o);
    }
}
