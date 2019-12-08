package com.automation.techassessment.api.endpoints.tv;

import com.beust.jcommander.Parameter;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TVEndpoint {
    String BASE_URL = "tv";

    @GET(BASE_URL + "/{tvId}")
    Call<TVResponse> getTVShowById(@Path("tvId") String tvId);

    @GET("search/" + BASE_URL)
    Call<SearchResponseTV> searchTV(@Query("query") String query);

    @GET("search/" + BASE_URL)
    Call<SearchResponseTV> searchTV(@Query("query") String query , @Query("page") String page);

    @GET("search/" + BASE_URL)
    Call<SearchResponseTV> searchTV(@Query("query") String query , @Query("page") String page , @Query("first_air_date_year") String first_air_date_year);

}