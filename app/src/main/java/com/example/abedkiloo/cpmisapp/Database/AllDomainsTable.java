package com.example.abedkiloo.cpmisapp.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "AllDomainsTable")
public class AllDomainsTable implements Serializable {


    public int getLocal_domain_id() {
        return local_domain_id;
    }

    public void setLocal_domain_id(int local_domain_id) {
        this.local_domain_id = local_domain_id;
    }

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

    @PrimaryKey(autoGenerate = true)
    private int local_domain_id;
    @ColumnInfo(name = "id")
    private String id;
    @ColumnInfo(name = "item_id")
    private String item_id;
    @ColumnInfo(name = "item_description")
    private String item_description;
    @ColumnInfo(name = "item_description_short")
    private String item_description_short;
    @ColumnInfo(name = "item_category")
    private String item_category;
    @ColumnInfo(name = "item_sub_category")
    private String item_sub_category;
    @ColumnInfo(name = "the_order")
    private String the_order;
    @ColumnInfo(name = "user_configurable")
    private String user_configurable;
    @ColumnInfo(name = "sms_keyword")
    private String sms_keyword;
    @ColumnInfo(name = "is_void")
    private String is_void;
    @ColumnInfo(name = "field_name")
    private String field_name;
    @ColumnInfo(name = "timestamp_modified")
    private String timestamp_modified;


}
