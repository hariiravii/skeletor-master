package com.automation.techassessment.api.endpoints.tv;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieEndpoint {
    String BASE_URL = "movie";
    String adult = "false";

    @GET("search/" + BASE_URL)
    Call<SearchResponseMovie> searchMovie(@Query("query") String query);

    @GET("search/" + BASE_URL)
    Call<SearchResponseMovie> searchMovie(@Query("query") String query , @Query("include_adult") String adult);



}