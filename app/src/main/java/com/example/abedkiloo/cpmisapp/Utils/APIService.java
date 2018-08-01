package com.example.abedkiloo.cpmisapp.Utils;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface APIService {


    //the signin call
//    @Headers("Content-Type: application/json")
    @FormUrlEncoded
    @POST("login/")
    Call<Result> userLogin(
            @Field("username") String username,
            @Field("password") String password
    );

    /**
     * getting cbos
     *
     * @return
     */
    @GET("registry/cbo/")
    Call<Result> getOrgUnit();


    @GET
    Call<OVCObject> getOrgUnitOvc(@Url String url);

}
