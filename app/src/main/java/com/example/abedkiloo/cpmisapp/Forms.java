package com.example.abedkiloo.cpmisapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.abedkiloo.cpmisapp.OVC_CARE_Forms.Activities.CSI;
import com.example.abedkiloo.cpmisapp.Utils.CPMISSharedPrerences;
import com.example.abedkiloo.cpmisapp.Utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

public class Forms extends AppCompatActivity {
    @BindView(R.id.spinner_select_form)
    AppCompatSpinner spinnerSelectForm;
    @BindView(R.id.btn_fill_details)
    Button btn_fill_details;

    CPMISSharedPrerences cpmisSharedPrerences;

    Class selected_form = null;
    ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms);
        ButterKnife.bind(this);


        /**
         * intialize shared preferences object
         */
        cpmisSharedPrerences = new CPMISSharedPrerences(getApplicationContext());
        populateSpinner();
        //form_navigation();
    }

    @OnClick(R.id.btn_fill_details)
    void click() {

        Intent form1a = new Intent(Forms.this, selected_form);
        startActivity(form1a);
    }

    @OnItemSelected(R.id.spinner_select_form)
    public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long id) {
        String str = (String) parent.getItemAtPosition(pos);
        if (str.equals(Constants.Child_Status_Index_form)) {
            selected_form = CSI.class;
        }
//        Toast.makeText(this, str, Toast.
// LENGTH_SHORT).show();
    }

//
//    private void form_navigation() {
//        spinnerSelectForm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//    }

    private void populateSpinner() {
        String[] criteria =
                new String[]{"Please Select Form", Constants.Child_Status_Index_form, "Household Assessment", "Service and Monitoring(Form 1A)", "CaregiverAssessment"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, criteria);
        spinnerSelectForm.setAdapter(adapter);

    }


}
