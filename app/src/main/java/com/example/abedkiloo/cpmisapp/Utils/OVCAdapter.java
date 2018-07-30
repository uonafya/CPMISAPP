package com.example.abedkiloo.cpmisapp.Utils;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abedkiloo.cpmisapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OVCAdapter extends RecyclerView.Adapter<OVCAdapter.MyViewHolder> {

    private List<OVC> ovcList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ovc_location)
        AppCompatTextView ovc_location;
        @BindView(R.id.ovc_gender)
        AppCompatTextView ovc_gender;
        @BindView(R.id.ovc_name)
        AppCompatTextView ovc_name;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);

        }
    }


    public OVCAdapter(List<OVC> moviesList) {
        this.ovcList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ovc_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        OVC movie = ovcList.get(position);
        holder.ovc_location.setText(movie.getLocation());
        holder.ovc_name.setText(movie.getName());
    }

    @Override
    public int getItemCount() {
        return ovcList.size();
    }
}
