package com.example.abedkiloo.cpmisapp.OVC_CARE_Forms.Fragments.Form1A;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.example.abedkiloo.cpmisapp.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Form1AAssessment extends Fragment {


    @BindView(R.id.f1assesabtnPickDate)
    AppCompatButton f1assesabtnPickDate;

    public Form1AAssessment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind((Activity) getContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_domain_evalution, container, false);
    }

    public void showCalender() {
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                // TODO Auto-generated method stub
//                calendar.set(Calendar.YEAR, year);
//                calendar.set(Calendar.MONTH, monthOfYear);
//                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            }
        };
    }


}
