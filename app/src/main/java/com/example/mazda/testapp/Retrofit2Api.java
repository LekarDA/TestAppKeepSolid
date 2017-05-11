package com.example.mazda.testapp;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by mazda on 10.05.2017.
 */

public interface Retrofit2Api {

    @POST("/")
    @FormUrlEncoded
    Call<JSONObject> getToken(@Field("action") String action,@Field("service") String service,
                              @Field("login") String login, @Field("password") String password,
                              @Field("deviceid") String deviceid, @Field("device") String device,
                              @Field("platform") String platform, @Field("platformversion") String platformversion,
                              @Field("appversion") String appversion, @Field("locale") String locale,
                              @Field("timezone") String timezone);
}
