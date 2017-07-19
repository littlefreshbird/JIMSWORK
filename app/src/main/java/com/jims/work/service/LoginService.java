package com.jims.work.service;


import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;


public interface LoginService {
  /*  @POST("/user/userLogin")
    Call<LoginResult> getData(@Body User user);*/
  @FormUrlEncoded
  @POST("ServiceforJims/user/userLogin.do")
  //Call<ResponseBody> getUserByLogin(@Field("account") String account, @Field("password") String password);
  Call<ResponseBody> getUserByLogin(@FieldMap Map<String, Object> map);


  @FormUrlEncoded
  @POST("ServiceforJims/user/userRegist.do")

  Call<ResponseBody> userRegist(@FieldMap Map<String, Object> map);





  @Multipart
  @POST("ServiceforJims/user/updateUserIcon.do")
  Call<ResponseBody> uploadUserIcon(@PartMap Map<String, Object> map, @Part MultipartBody.Part file);
}
