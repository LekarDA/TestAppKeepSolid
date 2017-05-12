package com.example.mazda.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonElement;

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

        Call<JsonElement> callback = RetrofitConfig.getService().getToken(action, service, login,
                password, deviceid, device, platform, platformversion, appversion, locale, timezone);
        callback.enqueue(new Callback<JsonElement>() {

            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                Log.e("SUCCESS", response.body().toString());
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
