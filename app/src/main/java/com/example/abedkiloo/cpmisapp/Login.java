package com.example.abedkiloo.cpmisapp;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.abedkiloo.cpmisapp.Utils.Constants;
import com.example.abedkiloo.cpmisapp.Utils.MySingleton;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends AppCompatActivity {

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
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }

    /**
     * --login for user--
     **/

    @OnClick(R.id.btn_login)
    void click() {
        Intent form1a = new Intent(Login.this, OVC_CARE.class);
        startActivity(form1a);

        user_name = editTextUserName.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();

        StringRequest loginRequest = new StringRequest(Request.Method.POST, Constants.Login_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("POST_LOGIN", response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", user_name);
                params.put("password", password);
                return params;
            }
        };
//        MySingleton.getmInstance().addToRequestQueue(loginRequest);


        if (user_name.isEmpty()) {
            editTextUserName.setError("Please provide user name");
        }
        if (password.isEmpty()) {
            editTextPassword.setError("Enter Password");
        }
    }

}
