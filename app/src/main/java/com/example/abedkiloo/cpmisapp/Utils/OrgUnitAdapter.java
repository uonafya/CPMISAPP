package com.example.abedkiloo.cpmisapp.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.example.abedkiloo.cpmisapp.CPIMSActivities.MainActivity;
import com.example.abedkiloo.cpmisapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrgUnitAdapter extends RecyclerView.Adapter<OrgUnitAdapter.MyViewHolder> implements Filterable {

    private Context mCtx;
    private List<OrgUnit> orgUnitList;
    private List<OrgUnit> orgUnitListFiltered;

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
        this.orgUnitList = orgUnits;
    }

    public OrgUnitAdapter(Context ctx, List<OrgUnit> orgUnits) {
        this.orgUnitList = orgUnits;
        this.mCtx = ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.org_unit_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final OrgUnit orgUnit = orgUnitList.get(position);
        if (position % 2 == 0) {
            holder.orgUnitId.setBackgroundResource(R.color.colorAccent);
            holder.linear_orgunit.setBackgroundResource(R.color.colorAccent1);
        }
        holder.orgUnitId.setText(orgUnit.getOrgUnitId());
        holder.orgunits.setText(orgUnit.getOrgUntName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent orgUnitIntent = new Intent(view.getContext(), MainActivity.class);
                orgUnitIntent.putExtra("ORG_UNIT_ID", orgUnit.getId());
                mCtx.startActivity(orgUnitIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orgUnitList.size();
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    orgUnitListFiltered = orgUnitList;
                } else {
                    List<OrgUnit> filteredList = new ArrayList<>();
                    for (OrgUnit row : orgUnitList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getOrgUntName().toLowerCase().contains(charString.toLowerCase()) || row.getOrgUnitId().contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    orgUnitListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = orgUnitListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                orgUnitListFiltered = (ArrayList<OrgUnit>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
