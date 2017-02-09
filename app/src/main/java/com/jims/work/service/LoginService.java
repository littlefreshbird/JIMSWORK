package com.jims.work.service;


import com.jims.work.bean.LoginResult;
import com.jims.work.bean.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by wzm on 2017/2/6.
 */

public interface LoginService {
    @POST("login/")
    Call<LoginResult> getData(@Body User user);
}
