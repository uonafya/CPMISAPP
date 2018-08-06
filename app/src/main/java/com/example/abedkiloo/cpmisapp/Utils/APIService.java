package com.example.abedkiloo.cpmisapp.Utils;

import com.example.abedkiloo.cpmisapp.Database.Services;
import com.example.abedkiloo.cpmisapp.Utils.Form1A.Domains.AllDomains;
import com.example.abedkiloo.cpmisapp.Utils.Form1A.Domains.Payload;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
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

    /**
     * getting domains
     *
     * @return
     */
    @GET("main/setuplists/?item_category=Domain&limit=40&offset=0")
    Call<AllDomains> getDomains();


    @GET
    Call<OVCObject> getOrgUnitOvc(@Url String url);


    @POST("main/setuplists/children/")
    Call<List<Services>> getDomains(@Body Payload domainPayload);

}
