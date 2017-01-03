package com.example.siddhesh.collegeportal;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by SIDDHESH on 04-01-2017.
 */

public interface Validation {
    @FormUrlEncoded
    @POST("/login.php")

    public void validate (
            @Field("username") String username,
            @Field("pass") String password,
            Callback<Response> callback
    );
}
