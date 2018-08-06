package com.example.abedkiloo.cpmisapp.Utils.Form1A.Domains;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AllDomainsResuts implements Serializable {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public String getItem_description_short() {
        return item_description_short;
    }

    public void setItem_description_short(String item_description_short) {
        this.item_description_short = item_description_short;
    }

    public String getItem_category() {
        return item_category;
    }

    public void setItem_category(String item_category) {
        this.item_category = item_category;
    }

    public String getItem_sub_category() {
        return item_sub_category;
    }

    public void setItem_sub_category(String item_sub_category) {
        this.item_sub_category = item_sub_category;
    }

    public String getThe_order() {
        return the_order;
    }

    public void setThe_order(String the_order) {
        this.the_order = the_order;
    }

    public String getUser_configurable() {
        return user_configurable;
    }

    public void setUser_configurable(String user_configurable) {
        this.user_configurable = user_configurable;
    }

    public String getSms_keyword() {
        return sms_keyword;
    }

    public void setSms_keyword(String sms_keyword) {
        this.sms_keyword = sms_keyword;
    }

    public String getIs_void() {
        return is_void;
    }

    public void setIs_void(String is_void) {
        this.is_void = is_void;
    }

    public String getField_name() {
        return field_name;
    }

    public void setField_name(String field_name) {
        this.field_name = field_name;
    }

    public String getTimestamp_modified() {
        return timestamp_modified;
    }

    public void setTimestamp_modified(String timestamp_modified) {
        this.timestamp_modified = timestamp_modified;
    }

    @SerializedName("id")
    public String id;
    @SerializedName("item_id")
    public String item_id;
    @SerializedName("item_description")
    public String item_description;
    @SerializedName("item_description_short")
    public String item_description_short;
    @SerializedName("item_category")
    public String item_category;
    @SerializedName("item_sub_category")
    public String item_sub_category;
    @SerializedName("the_order")
    public String the_order;
    @SerializedName("user_configurable")
    public String user_configurable;
    @SerializedName("sms_keyword")
    public String sms_keyword;
    @SerializedName("is_void")
    public String is_void;
    @SerializedName("field_name")
    public String field_name;
    @SerializedName("timestamp_modified")
    public String timestamp_modified;
}
