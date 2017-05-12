package com.example.mazda.testapp;

import android.util.Base64;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mazda on 10.05.2017.
 */

public class RetrofitConfig {

    private static final String BASE_URL = "https://dev-auth.simplexsolutionsinc.com";

    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(CLIENT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static final OkHttpClient CLIENT = new OkHttpClient.Builder()
            .readTimeout(60000, TimeUnit.MILLISECONDS)
            .writeTimeout(60000, TimeUnit.MILLISECONDS)
            .addInterceptor(new Base64EncodingInterceptor())
            .build();

    public static Retrofit2Api getService() {
        return getRetrofit().create(Retrofit2Api.class);
    }
}
