package com.example.abedkiloo.cpmisapp.CPIMSActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.abedkiloo.cpmisapp.OVC_CARE_Forms.Activities.CSI;
import com.example.abedkiloo.cpmisapp.R;
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
        if (selected_form == null) {
            Toast.makeText(this, "Please Select a Form", Toast.LENGTH_SHORT).show();

        } else {
            Intent form1a = new Intent(Forms.this, selected_form);
            startActivity(form1a);

        }
    }

    @OnItemSelected(R.id.spinner_select_form)
    public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long id) {
        String str = (String) parent.getItemAtPosition(pos);
        switch (str) {
            case Constants.Please_Select_Form:
                selected_form = null;
                break;
            case Constants.Child_Status_Index_Form:
                selected_form = CSI.class;
                break;
            case Constants.Household_Assessment_Form:
                selected_form = CSI.class;
                break;
            case Constants.Service_and_Monitoring_Form:
                selected_form = CSI.class;
                break;
            case Constants.Caregiver_Assessment_Form:
                selected_form = CSI.class;
                break;

        }
    }


    private void populateSpinner() {
        String[] criteria =
                new String[]{"Please Select Form", Constants.Child_Status_Index_Form, Constants.Household_Assessment_Form,
                        Constants.Service_and_Monitoring_Form, Constants.Caregiver_Assessment_Form};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, criteria);
        spinnerSelectForm.setAdapter(adapter);

    }


}
