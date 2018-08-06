package com.example.abedkiloo.cpmisapp.Utils.Form1A.Domains;

import com.example.abedkiloo.cpmisapp.Utils.Form1A.Service.ServiceObjectResult;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;

import java.util.List;

public class DomainObject {


    public String getItem_sub_category() {
        return item_sub_category;
    }

    public void setItem_sub_category(String item_sub_category) {
        this.item_sub_category = item_sub_category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getItem_sub_category_id() {
        return item_sub_category_id;
    }

    public void setItem_sub_category_id(String item_sub_category_id) {
        this.item_sub_category_id = item_sub_category_id;
    }

    @SerializedName("item_sub_category")
    private String item_sub_category;
    @SerializedName("status")
    private String status;
    @SerializedName("item_sub_category_id")
    private String item_sub_category_id;

}
