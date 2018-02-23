package com.example.administrator.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/2/23.
 */

public interface MovieService {
    //获取豆瓣Top250 榜单
    @GET("top250")
    Call<MovieSubject> getTop250(@Query("start") int start, @Query("count") int count);
}

