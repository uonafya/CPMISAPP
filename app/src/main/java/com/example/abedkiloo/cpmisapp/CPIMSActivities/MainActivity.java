package com.example.abedkiloo.cpmisapp.CPIMSActivities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.abedkiloo.cpmisapp.Database.CBOs;
import com.example.abedkiloo.cpmisapp.Database.CPIMSDbClient;
import com.example.abedkiloo.cpmisapp.Database.Domains;
import com.example.abedkiloo.cpmisapp.Database.OVCs;
import com.example.abedkiloo.cpmisapp.R;
import com.example.abedkiloo.cpmisapp.Utils.APIService;
import com.example.abedkiloo.cpmisapp.Utils.CPMISSessionManager;
import com.example.abedkiloo.cpmisapp.Utils.Constants;
import com.example.abedkiloo.cpmisapp.Utils.Form1A.Domains.DomainPayload;
import com.example.abedkiloo.cpmisapp.Utils.OVC;
import com.example.abedkiloo.cpmisapp.Utils.OVCAdapter;
import com.example.abedkiloo.cpmisapp.Utils.OrgUnit;
import com.example.abedkiloo.cpmisapp.Utils.OVCObject;
import com.example.abedkiloo.cpmisapp.Utils.OrgUnitAdapter;
import com.example.abedkiloo.cpmisapp.Utils.Result;
import com.example.abedkiloo.cpmisapp.Utils.User;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    CPMISSessionManager cpmisSessionManager;

    private List<OVC> ovclist = new ArrayList<>();


    // orgunit id
    String orgUnitId = "";


    @BindView(R.id.ovcRecycler)
    RecyclerView ovcRecycler;

    @BindView(R.id.ovc_search)
    SearchView ovcSearchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        getActionBar().setHomeButtonEnabled(true);

        cpmisSessionManager = new CPMISSessionManager(getApplicationContext());
        cpmisSessionManager.checkLogin();


        /**
         * get orgunit Id
         */
        Intent intent = getIntent();
        if (intent.getStringExtra("ORG_UNIT_ID") != null) {
            orgUnitId = intent.getStringExtra("ORG_UNIT_ID");
        }
/**
 * initialize other views
 */
        OVCAdapter ovcAdapter = new OVCAdapter(ovclist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        ovcRecycler.setLayoutManager(mLayoutManager);
        ovcRecycler.setItemAnimator(new DefaultItemAnimator());
        ovcRecycler.setAdapter(ovcAdapter);

//        ovcSearchView = findViewById(R.id.ovc_search);
        ovcSearchView.setIconified(false);

        String OVC_URL = "ovc/orgunit/" + orgUnitId + "/ovcs/?limit=100&offset=0";
        fetchOVCOnline(OVC_URL);


        /**
         * ovc from the local db
         */
        OVCsLocally();


    }


    private void OVCsLocally() {
        class GetOVCs extends AsyncTask<Void, Void, List<OVCs>> {

            @Override
            protected List<OVCs> doInBackground(Void... voids) {
                List<OVCs> taskList = CPIMSDbClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .ovCsDAO()
                        .getOrgUnitOVCs();
                return taskList;
            }

            @Override
            protected void onPostExecute(List<OVCs> tasks) {
                super.onPostExecute(tasks);
//                Log.e("CBOS_DB", String.valueOf(tasks.get(3).getOrg_unit()));
                Gson gson = new Gson();
                for (OVCs _tasks : tasks) {
                    OVC user = gson.fromJson(_tasks.getPerson(), OVC.class);
                    ovclist.add(user);
                }


            }
        }

        GetOVCs gt = new GetOVCs();
        gt.execute();
    }


    public void fetchOVCOnline(String url) {


        /**
         * set authorization to JWT {token}
         */
        OkHttpClient.Builder okHttpClient = new OkHttpClient().newBuilder();
        okHttpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request.Builder builder = originalRequest.newBuilder().
                        header("Authorization", "JWT " + cpmisSessionManager.get_auth_token());

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        });
        OkHttpClient client = okHttpClient.build();


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
//        String OVC_URL = "ovc/orgunit/" + orgUnitId + "/ovcs/?limit=100&offset=0";
        Call<OVCObject> call = service.getOrgUnitOvc(url);

        /**
         * calling the api
         */


        call.enqueue(new Callback<OVCObject>() {
            @Override
            public void onResponse(Call<OVCObject> call, final retrofit2.Response<OVCObject> response) {
                if (response.isSuccessful()) {
                    final int objCount = Integer.parseInt(String.valueOf(response.body().getCount()));

                    if (cpmisSessionManager.get_ovc_count(orgUnitId) <= Integer.parseInt(String.valueOf(response.body().getCount()))) {

                        @SuppressLint("StaticFieldLeak")
                        class SaveOVCs extends AsyncTask<Void, Void, Void> {


                            @Override
                            protected Void doInBackground(Void... voids) {
                                OVCs ovCs = new OVCs();
                                Gson gson = new Gson();

                                for (int i = 0; i < response.body().getResults().size(); i++) {
                                    String person_json = gson.toJson(response.body().getResults().get(i).getPerson());
                                    ovCs.setPerson(person_json);
                                    ovCs.setId(response.body().getResults().get(i).getId());
                                    ovCs.setRegistration_date(response.body().getResults().get(i).getRegistration_date());
                                    ovCs.setHas_bcert(response.body().getResults().get(i).getHas_bcert());
                                    ovCs.setIs_disabled(response.body().getResults().get(i).getIs_disabled());
                                    ovCs.setHiv_status(response.body().getResults().get(i).getHiv_status());
                                    ovCs.setArt_status(response.body().getResults().get(i).getArt_status());
                                    ovCs.setSchool_level(response.body().getResults().get(i).getSchool_level());
                                    ovCs.setImmunization_status(response.body().getResults().get(i).getImmunization_status());
                                    ovCs.setOrg_unique_id(response.body().getResults().get(i).getOrg_unique_id());
                                    ovCs.setOrg_unique_id(response.body().getResults().get(i).getOrg_unique_id());
                                    ovCs.setExit_date(response.body().getResults().get(i).getExit_date());
                                    ovCs.setCreated_at(response.body().getResults().get(i).getCreated_at());
                                    ovCs.setIs_active(response.body().getResults().get(i).getIs_active());
                                    ovCs.setIs_void(response.body().getResults().get(i).getIs_void());
                                    ovCs.setCaretaker(response.body().getResults().get(i).getCaretaker());
                                    ovCs.setChild_cbo(response.body().getResults().get(i).getChild_cbo());
                                    ovCs.setChild_chv(response.body().getResults().get(i).getChild_chv());

                                    CPIMSDbClient.getInstance(getApplicationContext()).getAppDatabase().ovCsDAO().insert(ovCs);
                                }
                                return null;
                            }

                            @Override
                            protected void onPostExecute(Void aVoid) {
                                super.onPostExecute(aVoid);


                                Toast.makeText(getApplicationContext(), "Saved " + cpmisSessionManager.get_ovc_count(orgUnitId) + " out of " + objCount, Toast.LENGTH_LONG).show();
                                Log.e("POST EXECUTE", "finished saving");
                                cpmisSessionManager.update_ovc_count(cpmisSessionManager.get_ovc_count(orgUnitId) + 100, orgUnitId);

                                if (response.body().getNext() != null) {
                                    String nextURL = String.valueOf(response.body().getNext());
                                    nextURL = nextURL.replaceAll("http://41.89.94.98/api/", "");
//                                    Log.e("Fetching NEXT", "=========================================================");
//                                    Log.e("URL", nextURL);
//                                    Log.e("Fetching NEXT", "=========================================================");
                                    fetchOVCOnline(nextURL);
                                } else {
                                    finish();
                                    startActivity(getIntent());
                                    Toast.makeText(getApplicationContext(), "Finished Saving the OVCs", Toast.LENGTH_LONG).show();

                                }


                            }
                        }

                        SaveOVCs saveOVCs = new SaveOVCs();
                        saveOVCs.execute();
                    }

//                    }


                } else {
                    try {
                        Log.e("RETRO_SUCCESS_ERROR_1", response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<OVCObject> call, Throwable t) {
//                Toast.makeText(OrgUnitSelect.this, String.valueOf(t), Toast.LENGTH_SHORT).show();
                Log.e("RETRO_FAILURE_ERROR_1", String.valueOf(t));


            }
        });
    }


//    private void prepareOVCData() {
//        OVC ovc = new OVC("Abednego Kilonzo Wambua", "Kaunde Location");
//        ovclist.add(ovc);
//        ovc = new OVC("Sila Maina Kimani", "Kaunde Location");
//        ovclist.add(ovc);
//        ovc = new OVC("Gracie Nyakio Mugendi", "Kaunde Location");
//        ovclist.add(ovc);
//
//    }
}
