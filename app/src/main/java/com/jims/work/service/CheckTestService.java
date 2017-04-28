package com.jims.work.service;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CheckTestService {

    @FormUrlEncoded
    @POST("Mybaits/checktest/checkList.do")
        //Call<ResponseBody> getUserByLogin(@Field("account") String account, @Field("password") String password);
    Call<ResponseBody> checkList(@Field("id") int id);

}

