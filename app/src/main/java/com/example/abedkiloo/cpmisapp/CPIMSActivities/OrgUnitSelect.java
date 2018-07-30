package com.example.abedkiloo.cpmisapp.CPIMSActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.abedkiloo.cpmisapp.R;
import com.example.abedkiloo.cpmisapp.Utils.CPMISSessionManager;
import com.example.abedkiloo.cpmisapp.Utils.OVC;
import com.example.abedkiloo.cpmisapp.Utils.OVCAdapter;
import com.example.abedkiloo.cpmisapp.Utils.OrgUnit;
import com.example.abedkiloo.cpmisapp.Utils.OrgUnitAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrgUnitSelect extends AppCompatActivity {


    @BindView(R.id.orgUnitSelectRecycle)
    RecyclerView orgUnitSelectRecycle;

    CPMISSessionManager cpmisSessionManager;
    private List<OrgUnit> orgUnits = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_unit_select);
        ButterKnife.bind(this);

        cpmisSessionManager = new CPMISSessionManager(getApplicationContext());
        cpmisSessionManager.checkLogin();


        OrgUnitAdapter ovcAdapter = new OrgUnitAdapter(orgUnits);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        orgUnitSelectRecycle.setLayoutManager(mLayoutManager);
        orgUnitSelectRecycle.setItemAnimator(new DefaultItemAnimator());
        orgUnitSelectRecycle.setAdapter(ovcAdapter);
        prepareOVCData();

    }
    private void prepareOVCData() {
        OrgUnit orgUnit = new OrgUnit("CommunityAsset Buiding An Construction", "ID :2463");
        orgUnits.add(orgUnit);
        orgUnit = new OrgUnit("Jiu Pach CBO", "ID : 2936");
        orgUnits.add(orgUnit);
        orgUnit = new OrgUnit("MuvA Child Care", "ID: 6633");
        orgUnits.add(orgUnit);

    }
}
