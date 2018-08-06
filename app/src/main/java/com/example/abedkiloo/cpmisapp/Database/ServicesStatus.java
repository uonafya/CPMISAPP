package com.example.abedkiloo.cpmisapp.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "ServicesStatus")
public class ServicesStatus implements Serializable {

    public int getLocal_service_status_id() {
        return local_service_status_id;
    }

    public void setLocal_service_status_id(int local_service_status_id) {
        this.local_service_status_id = local_service_status_id;
    }

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

    @PrimaryKey(autoGenerate = true)
    private int local_service_status_id;
    @ColumnInfo(name = "item_sub_category")
    private String item_sub_category;
    @ColumnInfo(name = "status")
    private String status;
    @ColumnInfo(name = "item_sub_category_id")
    private String item_sub_category_id;


}
