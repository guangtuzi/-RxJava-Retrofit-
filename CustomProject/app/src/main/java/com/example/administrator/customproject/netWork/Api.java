package com.example.administrator.customproject.netWork;


import com.example.administrator.customproject.netWork.response.LoginResponse;
import com.example.administrator.customproject.netWork.retrofit.FastJsonConverterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Api
 * <p>
 * Created by SLAN on 2016/6/29.
 */
public class Api {
    private ApiService mApiService;

    //在访问Api时创建单例
    private static class SingletonHolder {
        private static final Api INSTANCE = new Api(provideApiOkHttpClient());
    }

    //获取单例
    public static Api getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static OkHttpClient provideApiOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS) //
                .readTimeout(15, TimeUnit.SECONDS) //
                .writeTimeout(15, TimeUnit.SECONDS);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(logging);
        return builder.build();
    }

    private Api(OkHttpClient mOkHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()//
                .addConverterFactory(FastJsonConverterFactory.create())
                .client(mOkHttpClient)
                .baseUrl(UrlConstant.DOMAIN)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//
                .build();
        mApiService = retrofit.create(ApiService.class);
    }

    public void login(ProgressSubscriber<LoginResponse> subscriber, String username, String password, String deviceId) {
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
