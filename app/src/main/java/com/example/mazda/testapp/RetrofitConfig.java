package com.example.mazda.testapp;

import android.support.annotation.NonNull;
import android.util.Base64;
import android.util.Log;

import java.io.IOException;
import java.nio.Buffer;
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

//    private static String action = "login";
//    private static String service = "com.braininstock.ToDoChecklist";
//    private static String login = "kscheck007@mailinator.com";
//    private static String password = "123456";
//    private static String deviceid = "1234567890";
//    private static String device = "nexus5";
//    private static String platform = "Android";
//    private static String platformversion = "5.0";
//    private static String appversion = "1.0";
//    private static String locale = "en_US";
//    private static String timezone = "+0200";

    private  static Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dev-auth.simplexsolutionsinc.com")
                .client(getRequestHeader())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    private static OkHttpClient getRequestHeader() {
        OkHttpClient.Builder b = new OkHttpClient.Builder();
        b.readTimeout(60000, TimeUnit.MILLISECONDS);
        b.writeTimeout(60000, TimeUnit.MILLISECONDS);

        b.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                 Request.Builder builder = request.newBuilder().method(request.method(),encode(request.body()));

                return chain.proceed(builder.build());
            }
        });

        OkHttpClient httpClient = b.build();

        return httpClient;
    }


    private static RequestBody encode(final RequestBody body) {
        return new RequestBody() {
            @Override
            public MediaType contentType() {
                return body.contentType();
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {

//                Buffer buffer = new Buffer();
                body.writeTo(sink);

                byte[] encoded = Base64.encode(sink.buffer().readByteArray(), Base64.DEFAULT);
                sink.write(encoded);
                sink.close();
//                byte[] encodedAction = Base64.encode(action.getBytes(),Base64.DEFAULT);
//                encodedAction.toString();
//                sink.write(encodedAction);
//                byte[] encodedService = Base64.encode(service.getBytes(),Base64.DEFAULT);
//                sink.write(encodedService);
//                byte[] encodedLogin = Base64.encode(login.getBytes(),Base64.DEFAULT);
//                sink.write(encodedLogin);
//                byte[] encodedPassword = Base64.encode(password.getBytes(),Base64.DEFAULT);
//                sink.write(encodedPassword);
//                byte[] encodedDeviceid = Base64.encode(deviceid.getBytes(),Base64.DEFAULT);
//                sink.write(encodedDeviceid);
//                byte[] encodedDevice = Base64.encode(device.getBytes(),Base64.DEFAULT);
//                sink.write(encodedDevice);
//                byte[] encodedPlatform = Base64.encode(platform.getBytes(),Base64.DEFAULT);
//                sink.write(encodedPlatform);
//                byte[] encodedPlatformversion = Base64.encode(platformversion.getBytes(),Base64.DEFAULT);
//                sink.write(encodedPlatformversion);
//                byte[] encodedAppversion = Base64.encode(appversion.getBytes(),Base64.DEFAULT);
//                sink.write(encodedAppversion);
//                byte[] encodedlocale = Base64.encode(locale.getBytes(),Base64.DEFAULT);
//                sink.write(encodedlocale);
//                byte[] encodedtimezone = Base64.encode(timezone.getBytes(),Base64.DEFAULT);
//                sink.write(encodedtimezone);
//                sink.close();
            }
        };
    }



    public static Retrofit2Api getService(){
        return getRetrofit().create(Retrofit2Api.class);
    }
}
