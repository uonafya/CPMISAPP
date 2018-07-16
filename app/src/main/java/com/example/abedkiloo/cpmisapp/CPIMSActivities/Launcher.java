package com.example.abedkiloo.cpmisapp.CPIMSActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;

import com.example.abedkiloo.cpmisapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Launcher extends AppCompatActivity {


    @BindView(R.id.launch_gok)
    AppCompatButton launch_gok;
    @BindView(R.id.launch_usg)
    AppCompatButton launch_usg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.launch_gok)
    void launch_gok() {

    }

    @OnClick(R.id.launch_usg)
    void launch_usg() {
        Intent form1a = new Intent(Launcher.this, LoginUSG.class);
        startActivity(form1a);

    }
}
