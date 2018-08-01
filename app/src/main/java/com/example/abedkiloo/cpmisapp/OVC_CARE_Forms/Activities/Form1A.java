package com.example.abedkiloo.cpmisapp.OVC_CARE_Forms.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.abedkiloo.cpmisapp.OVC_CARE_Forms.Fragments.Form1A.Form1ACriticalEvents;
import com.example.abedkiloo.cpmisapp.OVC_CARE_Forms.Fragments.Form1A.Form1AAssessment;
import com.example.abedkiloo.cpmisapp.R;

public class Form1A extends AppCompatActivity {
    private ActionBar toolbar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        Fragment fragment;

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.form_1a_assessment:
                    toolbar.setTitle(R.string.form_1a_assessment);
                    fragment = new Form1AAssessment();
                    loadFragment(fragment);
                    return true;
                case R.id.form_1a_critical_events:
                    toolbar.setTitle(R.string.form_1a_critical_events);
                    fragment = new Form1ACriticalEvents();
                    loadFragment(fragment);
                    return true;
                case R.id.form_1a_priority_needs:
                    toolbar.setTitle(R.string.form_1a_priority_needs);
                    fragment = new Form1AAssessment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form1a);

        toolbar = getSupportActionBar();

//        // load the store fragment by default
        loadFragment(new Form1AAssessment());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        toolbar.setTitle(R.string.domain_evaluation);

    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.csi_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
