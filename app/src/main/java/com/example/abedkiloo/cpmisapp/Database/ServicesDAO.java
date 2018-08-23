package com.example.abedkiloo.cpmisapp.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.abedkiloo.cpmisapp.OVC_CARE_Forms.Fragments.Form1A.OVCServices;

import java.util.List;

@Dao
public interface ServicesDAO {
    @Query("SELECT * FROM Services")
    List<Services> getAll();


    @Query("SELECT * FROM Services WHERE item_sub_category = 2769")
    List<OVCServices> getServices();

    @Insert
    void insert(Services ovcs);

    @Delete
    void delete(Services ovcs);

    @Update
    void update(Services ovcs);
}
