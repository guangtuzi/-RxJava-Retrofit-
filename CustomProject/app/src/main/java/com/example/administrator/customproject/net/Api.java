package com.example.administrator.customproject.net;


import android.content.Context;

import com.example.administrator.customproject.dagger2.scope.ActivityContext;
import com.example.administrator.customproject.net.response.LoginResponse;
import com.example.administrator.customproject.net.retrofit.FastJsonConverterFactory;

import javax.inject.Named;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class Api {
    private Context mContext;
    private ApiService mApiService;

    public Api(@Named("api") OkHttpClient mOkHttpClient, @ActivityContext Context context) {
        mContext = context;
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(FastJsonConverterFactory.create())
                .client(mOkHttpClient)
                .baseUrl(UrlConstant.DOMAIN)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mApiService = retrofit.create(ApiService.class);
    }

    public void login(String username, String password, String deviceId, ProgressSubscriber<LoginResponse> subscriber) {
        mApiService.login(username, password, deviceId)
                .map(new HttpResultFunc<>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    private class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {
        @Override
        public T call(HttpResult<T> httpResult) {
            if (httpResult.getCode() != 0 || !httpResult.isSuccess()) {
                throw new ApiException(httpResult);
            }
            return httpResult.getData();
        }
    }
}
