package com.example.abedkiloo.cpmisapp.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.abedkiloo.cpmisapp.Utils.CBOResult;
import com.example.abedkiloo.cpmisapp.Utils.OrgUnit;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.List;

@Dao
public interface CBOsDAO {
    @Query("SELECT * FROM CBOs")
    List<CBOs> getAll();


    @Query("SELECT * FROM CBOs")
    List<CBOs> getOrgUnit();

    @Insert
    void insert(CBOs cbo);

    @Delete
    void delete(CBOs cbo);

    @Update
    void update(CBOs cbo);
}
