package com.example.abedkiloo.cpmisapp.OVC_CARE_Forms.Fragments.Form1A;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.abedkiloo.cpmisapp.Database.CPIMSDbClient;
import com.example.abedkiloo.cpmisapp.Database.Domains;
import com.example.abedkiloo.cpmisapp.Database.OVCs;
import com.example.abedkiloo.cpmisapp.R;
import com.example.abedkiloo.cpmisapp.Utils.APIService;
import com.example.abedkiloo.cpmisapp.Utils.Constants;
import com.example.abedkiloo.cpmisapp.Utils.Form1A.Domains.DomainObject;
import com.example.abedkiloo.cpmisapp.Utils.Form1A.Domains.DomainPayload;
import com.example.abedkiloo.cpmisapp.Utils.OVCObject;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Form1AAssessment extends Fragment {

    Calendar calendar;
    @BindView(R.id.btnPickDate)
    AppCompatButton btnPickDate;
    @BindView(R.id.setEditDate)
    AppCompatTextView setEditDate;
    @BindView(R.id.assessment_spinner)
    AppCompatSpinner assessment_spinner;
    @BindView(R.id.service_spinner)
    AppCompatSpinner service_spinner;
    @BindView(R.id.service_status_spinner)
    AppCompatSpinner service_status_spinner;

    private Unbinder unbinder;

    public Form1AAssessment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.form1a_assesement, container, false);
        unbinder = ButterKnife.bind(this, view);
        // Inflate the layout for this fragment

        populateAssessmentSpinner();
        //
        populateServiceSpinner();
        //
        populateServiceStatuSpinner();


//        setupDomains();
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnPickDate)
    public void click() {
        Toast.makeText(getContext(), "Pick date", Toast.LENGTH_SHORT).show();
        showCalender();
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());
        setEditDate.setText(sdf.format(calendar.getTime()));
    }


    private void populateAssessmentSpinner() {
        String[] criteria = new String[]{"Education", "Health & Nutrition", "HouseHold Economic Strengthening", "Protection", "Psychosocial Support", "Shelter and Care"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, criteria);
        assessment_spinner.setAdapter(adapter);
    }

    private void populateServiceSpinner() {
        String[] criteria = new String[]{"Names", "Household", "CHV", "CBO", "Caregiver"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, criteria);
        service_spinner.setAdapter(adapter);
    }

    private void populateServiceStatuSpinner() {
        String[] criteria = new String[]{"Active", "inactive"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, criteria);
        service_status_spinner.setAdapter(adapter);
    }

    public void showCalender() {
        calendar = Calendar.getInstance();

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };


        new DatePickerDialog(getContext(), date, calendar
                .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show();
    }



}
