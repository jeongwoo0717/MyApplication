package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitInterface
{
    // 첫 번째 데이터베이스 테이블에 대한 요청
    @GET("users1")
    Call<List<DataModel1>> getUsers1();

    // 두 번째 데이터베이스 테이블에 대한 요청
    @GET("users2")
    Call<List<DataModel2>> getUsers2();

    // 세 번째 데이터베이스 테이블에 대한 요청
    @GET("users3")
    Call<List<DataModel3>> getUsers3();

    @POST("save_token") // 서버의 토큰 등록 엔드포인트 경로
    Call<Void> sendTokenToServer(@Body Token token);

    @POST("users2")
    Call<Void> createUser(@Body DataModel user);
}
