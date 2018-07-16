package com.example.abedkiloo.cpmisapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OVC_CARE extends AppCompatActivity {


    @BindView(R.id.search_ovc_name)
    EditText editTextSearchOvcName;
    @BindView(R.id.spinner_search_criteria)
    AppCompatSpinner spinnerSearchCriteria;
    @BindView(R.id.btn_search)
    Button btn_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ovc__care);
        ButterKnife.bind(this);

        populateSpinner();
    }

    private void populateSpinner() {
        String[] criteria = new String[]{"Names", "Household", "CHV", "CBO", "Caregiver"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, criteria);
        spinnerSearchCriteria.setAdapter(adapter);

    }

    @OnClick(R.id.btn_search)
    void click() {

        Intent form1a = new Intent(OVC_CARE.this, Forms.class);
        startActivity(form1a);

    }
}
