package com.example.abedkiloo.cpmisapp.Utils;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.abedkiloo.cpmisapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrgUnitAdapter extends RecyclerView.Adapter<OrgUnitAdapter.MyViewHolder> {

    private List<OrgUnit> ovcList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.linear_orgunit)
        LinearLayout linear_orgunit;
        @BindView(R.id.orgunits)
        AppCompatTextView orgunits;
        @BindView(R.id.orgUnitId)
        AppCompatTextView orgUnitId;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);

        }
    }


    public OrgUnitAdapter(List<OrgUnit> orgUnits) {
        this.ovcList = orgUnits;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.org_unit_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        OrgUnit orgUnit = ovcList.get(position);
        if(position%2==0){
            holder.orgUnitId.setBackgroundResource(R.color.colorAccent);
            holder.linear_orgunit.setBackgroundResource(R.color.colorAccent1);
        }
        holder.orgUnitId.setText(orgUnit.getOrgUnitId());
        holder.orgunits.setText(orgUnit.getOrgUntName());
    }

    @Override
    public int getItemCount() {
        return ovcList.size();
    }
}
