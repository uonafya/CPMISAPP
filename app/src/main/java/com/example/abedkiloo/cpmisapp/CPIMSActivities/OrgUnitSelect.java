package com.example.abedkiloo.cpmisapp.CPIMSActivities;

import android.app.SearchManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.abedkiloo.cpmisapp.Database.CBOs;
import com.example.abedkiloo.cpmisapp.Database.CPIMSDbClient;
import com.example.abedkiloo.cpmisapp.R;
import com.example.abedkiloo.cpmisapp.Utils.APIService;
import com.example.abedkiloo.cpmisapp.Utils.CBOResult;
import com.example.abedkiloo.cpmisapp.Utils.CPMISSessionManager;
import com.example.abedkiloo.cpmisapp.Utils.Constants;
import com.example.abedkiloo.cpmisapp.Utils.OrgUnit;
import com.example.abedkiloo.cpmisapp.Utils.OrgUnitAdapter;
import com.example.abedkiloo.cpmisapp.Utils.Result;
import com.google.gson.Gson;


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
    private List<CBOResult> localcbos = new ArrayList<>();
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


        fetchOnline();

        CBOsLocally();


        /**
         * seraching through a list of items
         */
        if (isNetworkAvailable()) {
            searchingOrgunits();
        } else {
            CBOsLocally();
        }


    }

    private void CBOsLocally() {
        class GetCBOs extends AsyncTask<Void, Void, List<CBOs>> {

            @Override
            protected List<CBOs> doInBackground(Void... voids) {
                List<CBOs> taskList = CPIMSDbClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .cbOsDAO()
                        .getOrgUnit();
                return taskList;
            }

            @Override
            protected void onPostExecute(List<CBOs> tasks) {
                super.onPostExecute(tasks);
//                Log.e("CBOS_DB", String.valueOf(tasks.get(3).getOrg_unit()));
                Gson gson = new Gson();


                for (CBOs _tasks : tasks) {

                    OrgUnit orgUnit = gson.fromJson(_tasks.getOrg_unit(), OrgUnit.class);
                    orgUnits.add(orgUnit);
                }

                OrgUnitAdapter adapter = new OrgUnitAdapter(OrgUnitSelect.this, orgUnits);
                orgUnitSelectRecycle.setAdapter(adapter);
                orgUnitAdapter.notifyDataSetChanged();

            }
        }

        GetCBOs gt = new GetCBOs();
        gt.execute();
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


    private void fetchOnline() {
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
            public void onResponse(Call<Result> call, final retrofit2.Response<Result> response) {
                if (response.isSuccessful()) {
                    if (cpmisSessionManager.get_cbo_count() != Integer.parseInt(response.body().getCount())) {

/**
 *                         !todo add logic for new data
 */
                        class SaveCBOs extends AsyncTask<Void, Void, Void> {


                            @Override
                            protected Void doInBackground(Void... voids) {
                                CBOs cbOs = new CBOs();
                                Gson gson = new Gson();
                                for (int i = 0; i < response.body().getResults().size(); i++) {

                                    String org_unit_json = gson.toJson(response.body().getResults().get(i).getOrg_unit());
                                    String person_json = gson.toJson(response.body().getResults().get(i).getOrg_unit());

                                    cbOs.setOrg_unit(org_unit_json);

                                    cbOs.setPerson(person_json);

                                    CPIMSDbClient.getInstance(getApplicationContext()).getAppDatabase().cbOsDAO().insert(cbOs);

                                }
                                return null;
                            }

                            @Override
                            protected void onPostExecute(Void aVoid) {
                                super.onPostExecute(aVoid);
                                cpmisSessionManager.update_cbo_count(Integer.parseInt(response.body().getCount()));
                                Toast.makeText(getApplicationContext(), "Saved Org Units", Toast.LENGTH_LONG).show();
                                finish();
                                startActivity(getIntent());
                            }
                        }
                        SaveCBOs saveCBOs = new SaveCBOs();
                        saveCBOs.execute();
                    }

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

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
