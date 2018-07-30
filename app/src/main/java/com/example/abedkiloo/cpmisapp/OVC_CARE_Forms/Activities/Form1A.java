package com.example.abedkiloo.cpmisapp.OVC_CARE_Forms.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.abedkiloo.cpmisapp.R;
import com.example.abedkiloo.cpmisapp.Utils.CPMISSessionManager;

public class Form1A extends AppCompatActivity {

    CPMISSessionManager cpmisSessionManager;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_assessment:
                    mTextMessage.setText(R.string.form_1a_assessment);
                    return true;
                case R.id.navigation_critical_events:
                    mTextMessage.setText(R.string.form_1a_critical_events);
                    return true;
                case R.id.navigation_priority_need:
                    mTextMessage.setText(R.string.form_1a_priority_needs);
                    return true;
                case R.id.navigation_services:
                    mTextMessage.setText(R.string.form_1a_services);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form1);
        /**
         * session manager
         */
        cpmisSessionManager = new CPMISSessionManager(getApplicationContext());
        cpmisSessionManager.checkLogin();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
