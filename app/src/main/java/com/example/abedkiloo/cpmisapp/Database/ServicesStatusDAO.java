package com.example.abedkiloo.cpmisapp.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ServicesStatusDAO {
    @Query("SELECT * FROM ServicesStatus")
    List<Services> getAll();


    @Query("SELECT * FROM Services WHERE item_sub_category = 2769")
    List<ServicesStatus> getServiceStatus();

    @Insert
    void insert(ServicesStatus servicesStatus);

    @Delete
    void delete(ServicesStatus servicesStatus);

    @Update
    void update(ServicesStatus servicesStatus);
}
