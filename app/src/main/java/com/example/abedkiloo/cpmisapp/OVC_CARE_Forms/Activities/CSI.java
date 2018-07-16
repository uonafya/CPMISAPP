package com.example.abedkiloo.cpmisapp.OVC_CARE_Forms.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.abedkiloo.cpmisapp.OVC_CARE_Forms.Fragments.DomainEvalution;
import com.example.abedkiloo.cpmisapp.R;

public class CSI extends AppCompatActivity {
    private ActionBar toolbar;

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_domain_evaluation:
                    mTextMessage.setText(R.string.domain_evaluation);
                    return true;
                case R.id.navigation_csi_priorities:
                    mTextMessage.setText(R.string.csi_priorities);
                    return true;
                case R.id.navigation_support_service:
                    mTextMessage.setText(R.string.support_services);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csi);
//
//        toolbar = getSupportActionBar();
//
//        // load the store fragment by default
//        toolbar.setTitle(R.string.domain_evaluation);
//        loadFragment(new DomainEvalution());
//        mTextMessage = (TextView) findViewById(R.id.message);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.csi_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
