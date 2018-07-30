package com.example.abedkiloo.cpmisapp.CPIMSActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.example.abedkiloo.cpmisapp.R;
import com.example.abedkiloo.cpmisapp.Utils.CPMISSessionManager;
import com.example.abedkiloo.cpmisapp.Utils.OVC;
import com.example.abedkiloo.cpmisapp.Utils.OVCAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    CPMISSessionManager cpmisSessionManager;

    private List<OVC> ovclist = new ArrayList<>();


    @BindView(R.id.ovcRecycler)
    RecyclerView ovcRecycler;

    @BindView(R.id.ovc_search)
    SearchView ovcSearchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        cpmisSessionManager = new CPMISSessionManager(getApplicationContext());
        cpmisSessionManager.checkLogin();

        OVCAdapter ovcAdapter = new OVCAdapter(ovclist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        ovcRecycler.setLayoutManager(mLayoutManager);
        ovcRecycler.setItemAnimator(new DefaultItemAnimator());
        ovcRecycler.setAdapter(ovcAdapter);

//        ovcSearchView = findViewById(R.id.ovc_search);
//        ovcSearchView.setIconified(true);


        prepareOVCData();
    }


    private void prepareOVCData() {
        OVC ovc = new OVC("Abednego Kilonzo Wambua", "Kaunde Location");
        ovclist.add(ovc);
        ovc = new OVC("Sila Maina Kimani", "Kaunde Location");
        ovclist.add(ovc);
        ovc = new OVC("Gracie Nyakio Mugendi", "Kaunde Location");
        ovclist.add(ovc);

    }
}
