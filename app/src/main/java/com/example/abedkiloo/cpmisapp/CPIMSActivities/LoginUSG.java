package com.example.abedkiloo.cpmisapp.CPIMSActivities;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.abedkiloo.cpmisapp.OVC_CARE_Forms.Activities.Form1A;
import com.example.abedkiloo.cpmisapp.R;
import com.example.abedkiloo.cpmisapp.Utils.APIService;
import com.example.abedkiloo.cpmisapp.Utils.CPMISSessionManager;
import com.example.abedkiloo.cpmisapp.Utils.Constants;
import com.example.abedkiloo.cpmisapp.Utils.Result;
import com.example.abedkiloo.cpmisapp.Utils.User;
import com.google.gson.JsonObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginUSG extends AppCompatActivity {
    // Session Manager Class
    CPMISSessionManager cpmisSessionManager;
    /**
     * user credentials
     */
    String user_name = "";
    String password = "";


    /**
     * butter knife views
     */
    @BindView(R.id.text_input_user_name)
    TextInputLayout textInputLayoutUserNamel;
    @BindView(R.id.user_name)
    EditText editTextUserName;
    @BindView(R.id.text_input_password)
    TextInputLayout textInputLayoutPassword;
    @BindView(R.id.password)
    EditText editTextPassword;
    @BindView(R.id.btn_login)
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usg_activity_login);
        ButterKnife.bind(this);

        /**
         * begin session
         */
        cpmisSessionManager = new CPMISSessionManager(getApplicationContext());

    }

    /**
     * --login for user--
     **/

    @OnClick(R.id.btn_login)
    void click() {
/**
 * get user inputs to string
 */
        user_name = editTextUserName.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();

        if (user_name.isEmpty()) {
            editTextUserName.setError("Please provide user name");
        }
        if (password.isEmpty()) {
            editTextPassword.setError("Enter Password");
        } else {
/**
 * building a retrofit object
 */
            /**
             * set content type of application/json
             */
            OkHttpClient.Builder okHttpClient = new OkHttpClient().newBuilder();
            okHttpClient.addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {
                    Request originalRequest = chain.request();

                    Request.Builder builder = originalRequest.newBuilder().header("Content-Type", "application/json");

                    Request newRequest = builder.build();
                    return chain.proceed(newRequest);
                }
            });
            OkHttpClient client = okHttpClient.build();

/**
 * retrofit logger
 */
//        okHttpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
//        okHttpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS));


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
             */final User user = new User(user_name, password);


            /**
             * define the call
             */

            Call<Result> call = service.userLogin(user.getUsername(), user.getPassword());

            /**
             * calling the api
             */

            call.enqueue(new Callback<Result>() {
                @Override
                public void onResponse(Call<Result> call, retrofit2.Response<Result> response) {
                    if (response.isSuccessful()) {
                        /**
                         * redirect to user and store session
                         */

                        Log.e("SUCCESS", "==" + response.body().getToken());
                        Toast.makeText(LoginUSG.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                        cpmisSessionManager.createLoginSession(user.getUsername(), user.getPassword());
                        Intent form1a = new Intent(LoginUSG.this, OrgUnitSelect.class);
                        startActivity(form1a);
                    } else {
                        try {

                            Toast.makeText(LoginUSG.this, response.errorBody().string(), Toast.LENGTH_SHORT).show();
                            Log.e("RETRO_SUCCESS_ERROR_1", response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<Result> call, Throwable t) {
                    Toast.makeText(LoginUSG.this, String.valueOf(t), Toast.LENGTH_SHORT).show();
                    Log.e("RETRO_FAILURE_ERROR_1", String.valueOf(t));


                }
            });
        }

    }

}
