package com.example.mazda.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Interceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String action = "login";
    private String service = "com.braininstock.ToDoChecklist";
    private String login = "kscheck007@mailinator.com";
    private String password = "123456";
    private String deviceid = "1234567890";
    private String device = "nexus5";
    private String platform = "Android";
    private String platformversion = "5.0";
    private String appversion = "1.0";
    private String locale = "en_US";
    private String timezone = "+0200";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//
//        byte[] encodedAction = Base64.encode(action.getBytes(),Base64.DEFAULT);
//
//
//        byte[] encodedService = Base64.encode(service.getBytes(),Base64.DEFAULT);
//
//        byte[] encodedLogin = Base64.encode(login.getBytes(),Base64.DEFAULT);
//
//        byte[] encodedPassword = Base64.encode(password.getBytes(),Base64.DEFAULT);
//
//        byte[] encodedDeviceid = Base64.encode(deviceid.getBytes(),Base64.DEFAULT);
//
//        byte[] encodedDevice = Base64.encode(device.getBytes(),Base64.DEFAULT);
//
//        byte[] encodedPlatform = Base64.encode(platform.getBytes(),Base64.DEFAULT);
//
//        byte[] encodedPlatformversion = Base64.encode(platformversion.getBytes(),Base64.DEFAULT);
//
//        byte[] encodedAppversion = Base64.encode(appversion.getBytes(),Base64.DEFAULT);
//
//        byte[] encodedlocale = Base64.encode(locale.getBytes(),Base64.DEFAULT);
//
//        byte[] encodedtimezone = Base64.encode(timezone.getBytes(),Base64.DEFAULT);


        Call<JSONObject> callback = RetrofitConfig.getService().getToken(/*encodedAction.toString()*/action,
                /*encodedService.toString()*/service, /*encodedLogin.toString()*/login,
                /*encodedPassword.toString()*/password,/*encodedDeviceid.toString()*/deviceid,
                /*encodedDevice.toString()*/device,/*encodedPlatform.toString()*/platform,
                /*encodedPlatformversion.toString()*/platformversion,/*encodedAppversion.toString()*/appversion,
                /*encodedlocale.toString()*/locale,/*encodedtimezone.toString()*/timezone);
        callback.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                Log.e("SUCCESS", response.body().toString());
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failure",Toast.LENGTH_SHORT).show();
            }
        });
    }



}
