package com.example.abedkiloo.cpmisapp.CPIMSActivities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.abedkiloo.cpmisapp.R;
import com.example.abedkiloo.cpmisapp.Utils.APIService;
import com.example.abedkiloo.cpmisapp.Utils.CPMISSessionManager;
import com.example.abedkiloo.cpmisapp.Utils.Constants;
import com.example.abedkiloo.cpmisapp.Utils.OrgUnit;
import com.example.abedkiloo.cpmisapp.Utils.OrgUnitAdapter;
import com.example.abedkiloo.cpmisapp.Utils.Result;
import com.example.abedkiloo.cpmisapp.Utils.User;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OrgUnitSelect extends AppCompatActivity {


    @BindView(R.id.orgUnitSelectRecycle)
    RecyclerView orgUnitSelectRecycle;

    @BindView(R.id.orgunit_search)
    SearchView orgunit_search;

    CPMISSessionManager cpmisSessionManager;
    private List<OrgUnit> orgUnits = new ArrayList<>();
    private OrgUnitAdapter orgUnitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_unit_select);
        ButterKnife.bind(this);

        cpmisSessionManager = new CPMISSessionManager(getApplicationContext());
        cpmisSessionManager.checkLogin();


        orgUnitAdapter = new OrgUnitAdapter(orgUnits);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        orgUnitSelectRecycle.setLayoutManager(mLayoutManager);
        orgUnitSelectRecycle.setItemAnimator(new DefaultItemAnimator());
        orgUnitSelectRecycle.setAdapter(orgUnitAdapter);


        prepareOVCData();

        /**
         * seraching through a list of items
         */
        searchingOrgunits();


    }

    private boolean searchingOrgunits() {

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        orgunit_search.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        orgunit_search.setMaxWidth(Integer.MAX_VALUE);        // listening to search query text change
        orgunit_search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                orgUnitAdapter.getFilter().filter(query);
                Log.e("SEARCH_OVC", "TRUE");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                orgUnitAdapter.getFilter().filter(query);
                Log.e("SEARCH_OVC", "TRUE");

                return false;
            }
        });
        return false;
    }


    private void prepareOVCData() {
        /**
         * set authorization to JWT {token}
         */
        OkHttpClient.Builder okHttpClient = new OkHttpClient().newBuilder();
        okHttpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request.Builder builder = originalRequest.newBuilder().header("Authorization", "JWT eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImFiZWRraWxvbyIsIm9yaWdfaWF0IjoxNTMyOTYyODkzLCJ1c2VyX2lkIjo5NjEsImVtYWlsIjpudWxsLCJleHAiOjE1MzI5NjMxOTN9.JrN45JHRG8uC-51mBL1hQFLHDxxnw8uPlHAm4c-8czY"
                );
                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        });
        OkHttpClient client = okHttpClient.build();

/**
 * retrofit logger
 */
        okHttpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        okHttpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS));


/**
 * retrofit service
 */
        Retrofit.Builder builderretrofit = new Retrofit.Builder()
                .baseUrl(Constants.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client);
        Retrofit retrofit = builderretrofit.build();


        /**
         * defining the retrofit api service
         */
        APIService service = retrofit.create(APIService.class);

        /**
         * define use object to pass
         */
//        final User user = new User(user_name, password);


        /**
         * define the call
         */

        Call<Result> call = service.getOrgUnit();

        /**
         * calling the api
         */

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, retrofit2.Response<Result> response) {
                if (response.isSuccessful()) {

                    int objCount = Integer.parseInt(response.body().getCount());
                    Log.e("RETRO_SUCCESS_OBJECT", "++" + response.body().getResults().get(0).getOrg_unit().getOrgUnitId());
                    OrgUnit orgUnit;
                    for (int i = 0; i < objCount; i++) {
                        orgUnit = new OrgUnit();
                        orgUnit.setOrg_unit_name(response.body().getResults().get(i).getOrg_unit().getOrg_unit_name());
                        orgUnit.setOrgUnitId(response.body().getResults().get(i).getOrg_unit().getParent_org_unit_id());
                        orgUnits.add(orgUnit);
                    }
                    orgUnitAdapter.notifyDataSetChanged();
                } else {
                    try {
                        Log.e("RETRO_SUCCESS_ERROR_1", response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(OrgUnitSelect.this, String.valueOf(t), Toast.LENGTH_SHORT).show();
                Log.e("RETRO_FAILURE_ERROR_1", String.valueOf(t));


            }
        });


    }
}
