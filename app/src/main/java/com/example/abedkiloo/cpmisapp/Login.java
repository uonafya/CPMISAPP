package com.example.abedkiloo.cpmisapp;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends AppCompatActivity {

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

        /**
         * --login for user--**/
        click();
    }

    @OnClick(R.id.btn_login)
    void click() {
        String user_name = editTextUserName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (user_name.isEmpty()) {
            editTextUserName.setError("Please provide user name");
        }
        if (password.isEmpty()) {
            editTextPassword.setError("Enter Password");
        }
    }

}
