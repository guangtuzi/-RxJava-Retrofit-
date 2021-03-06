package com.example.administrator.customproject.net;

import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * KLog打印OkHttp网络请求日志
 */
public class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Logger.d(String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()));

        long t1 = System.nanoTime();
        okhttp3.Response response = chain.proceed(chain.request());
        long t2 = System.nanoTime();
        Logger.d(String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));

        okhttp3.MediaType mediaType = response.body().contentType();
        String content = response.body().string();
        Logger.json(content);
        return response.newBuilder()
                .body(okhttp3.ResponseBody.create(mediaType, content))
                .build();
    }
}