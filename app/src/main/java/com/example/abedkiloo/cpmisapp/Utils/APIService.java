package com.example.abedkiloo.cpmisapp.Utils;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {


    //the signin call
//    @Headers("Content-Type: application/json")
    @FormUrlEncoded
    @POST("login/")
    Call<Result> userLogin(
            @Field("username") String username,
            @Field("password") String password
//            @Body JsonObject user
    );


    @GET("registry/cbo/")
    Call<Result> getOrgUnit();

}
