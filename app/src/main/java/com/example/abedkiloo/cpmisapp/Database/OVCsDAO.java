package com.example.abedkiloo.cpmisapp.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface OVCsDAO {
    @Query("SELECT * FROM OVCs")
    List<OVCs> getAll();


    @Query("SELECT * FROM OVCs")
    List<OVCs> getOrgUnitOVCs();

    @Insert
    void insert(OVCs ovcs);

    @Delete
    void delete(OVCs ovcs);

    @Update
    void update(OVCs ovcs);
}
