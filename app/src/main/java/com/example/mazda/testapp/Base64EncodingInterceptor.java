package com.example.mazda.testapp;

import android.util.Base64;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;

public class Base64EncodingInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();
        Request newRequest = oldRequest.newBuilder()
                .method(oldRequest.method(), encode(oldRequest.body()))
                .build();
        return chain.proceed(newRequest);
    }

    private static RequestBody encode(final RequestBody body) {
        return new RequestBody() {

            @Override
            public MediaType contentType() {
                return body.contentType();
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                byte[] encoded = Base64.encode(buffer.readByteArray(), Base64.DEFAULT);
                sink.write(encoded);
                buffer.close();
                sink.close();
            }
        };
    }
}
