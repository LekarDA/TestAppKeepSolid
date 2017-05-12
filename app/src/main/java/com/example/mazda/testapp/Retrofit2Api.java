package com.example.mazda.testapp;

import com.google.gson.JsonElement;

import org.json.JSONObject;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Retrofit2Api {

    @POST("/")
    @FormUrlEncoded
    Call<JsonElement> getToken(
            @Field("action") String action,
            @Field("service") String service,
            @Field("login") String login,
            @Field("password") String password,
            @Field("deviceid") String deviceid,
            @Field("device") String device,
            @Field("platform") String platform,
            @Field("platformversion") String platformversion,
            @Field("appversion") String appversion,
            @Field("locale") String locale,
            @Field("timezone") String timezone
    );
}
