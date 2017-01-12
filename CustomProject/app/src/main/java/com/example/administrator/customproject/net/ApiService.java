package com.example.administrator.customproject.net;


import com.example.administrator.customproject.net.response.LoginResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {
    @GET(UrlConstant.LOGIN)
    Observable<HttpResult<LoginResponse>> login(@Query("username") String username, @Query("password") String password, @Query("deviceId") String deviceId);
}