package com.jims.work.service;


import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;



public interface LoginService {
  /*  @POST("/user/userLogin")
    Call<LoginResult> getData(@Body User user);*/
  @FormUrlEncoded
  @POST("Mybaits/user/userLogin.do")
  //Call<ResponseBody> getUserByLogin(@Field("account") String account, @Field("password") String password);
  Call<ResponseBody> getUserByLogin(@FieldMap Map<String, Object> map);
}
