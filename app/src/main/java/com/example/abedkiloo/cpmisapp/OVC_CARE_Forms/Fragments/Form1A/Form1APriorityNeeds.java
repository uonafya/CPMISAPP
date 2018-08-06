package com.example.abedkiloo.cpmisapp.OVC_CARE_Forms.Fragments.Form1A;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abedkiloo.cpmisapp.R;

public class Form1APriorityNeeds extends Fragment {


    public Form1APriorityNeeds() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_priority_needs, container, false);
    }


}
