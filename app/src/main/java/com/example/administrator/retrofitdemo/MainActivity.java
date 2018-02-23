package com.example.administrator.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    public static final String BASE_URL = "http://api.douban.com/v2/movie/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        //获取接口实例
        MovieService movieService = retrofit.create(MovieService.class);
//调用方法得到一个Call
        Call<MovieSubject> call = movieService.getTop250(0, 20);
        //进行网络请求
        call.enqueue(new Callback<MovieSubject>() {
            @Override
            public void onResponse(Call<MovieSubject> call, Response<MovieSubject> response) {
                Log.d(TAG, "onResponse: zhc");
                /*mMovieAdapter.setMovies(response.body().subjects);
                mMovieAdapter.notifyDataSetChanged();*/
            }

            @Override
            public void onFailure(Call<MovieSubject> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
