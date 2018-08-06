package com.example.abedkiloo.cpmisapp.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Services")
public class Services implements Serializable {


    public int getLocal_db_id() {
        return local_db_id;
    }

    public void setLocal_db_id(int local_db_id) {
        this.local_db_id = local_db_id;
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
    private int local_db_id;
    @ColumnInfo(name = "item_sub_category")
    private String item_sub_category;
    @ColumnInfo(name = "status")
    private String status;
    @ColumnInfo(name = "item_sub_category_id")
    private String item_sub_category_id;


}
