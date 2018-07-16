package com.example.abedkiloo.cpmisapp.OVC_CARE_Forms.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.abedkiloo.cpmisapp.OVC_CARE_Forms.Fragments.CSI.CSI_Priorities;
import com.example.abedkiloo.cpmisapp.OVC_CARE_Forms.Fragments.CSI.DomainEvalution;
import com.example.abedkiloo.cpmisapp.R;

public class CSI extends AppCompatActivity {
    private ActionBar toolbar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        Fragment fragment;

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_domain_evaluation:
                    toolbar.setTitle(R.string.domain_evaluation);
                    fragment = new DomainEvalution();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_csi_priorities:
                    toolbar.setTitle(R.string.csi_priorities);
                    fragment = new CSI_Priorities();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_support_service:
                    toolbar.setTitle(R.string.support_services);
                    fragment = new DomainEvalution();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csi);

        toolbar = getSupportActionBar();

//        // load the store fragment by default
        loadFragment(new DomainEvalution());

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
