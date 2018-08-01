package com.example.abedkiloo.cpmisapp.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "CBOs")
public class CBOs implements Serializable {


    public int getLocal_db_id() {
        return local_db_id;
    }

    public void setLocal_db_id(int local_db_id) {
        this.local_db_id = local_db_id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getOrg_unit() {
        return org_unit;
    }

    public void setOrg_unit(String org_unit) {
        this.org_unit = org_unit;
    }

    @PrimaryKey(autoGenerate = true)
    private int local_db_id;
    @ColumnInfo(name = "person")
    private String person;
    @ColumnInfo(name = "org_unit")
    private String org_unit;


}
