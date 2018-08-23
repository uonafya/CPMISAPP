package com.example.abedkiloo.cpmisapp.OVC_CARE_Forms.Fragments.Form1A;

import android.arch.persistence.room.ColumnInfo;

public class OVCServices {


    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    @ColumnInfo(name = "item_sub_category")
    public String item_description;
    @ColumnInfo(name = "item_sub_category_id")
    public String item_id;

}