package com.example.jsonfetching;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("api/v3/PublicHolidays/2017/AT")
    Call<List<Post>> getDetails();

}
