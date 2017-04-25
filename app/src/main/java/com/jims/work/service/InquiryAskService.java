package com.jims.work.service;

import com.jims.work.bean.MyAsklistInfor;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 问诊
 *
 * 请求参数
 *  参数	必选	类型	说明
 * page	否	int	请求页数，默认page=1
 * rows	否	int	每页返回的条数，默认rows=20
 * id	否	int	分类ID，默认返回的是全部。这里的ID就是指分类
 *
 * @Query 表示注解
 */
public interface InquiryAskService {
    @FormUrlEncoded
    @POST("Mybaits/user/getList.do")
        //Call<ResponseBody> getUserByLogin(@Field("account") String account, @Field("password") String password);
    Call<MyAsklistInfor> getList(@Path("category") String category, @Query("id") int id, @Query("page") int page, @Query("rows") int rows);

}
