package com.example.abedkiloo.cpmisapp.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DomainsDAO {
    @Query("SELECT * FROM DOMAIN")
    List<Domains> getAll();


    @Query("SELECT * FROM DOMAIN WHERE item_sub_category = 2769")
    List<Domains> getDomains();

    @Insert
    void insert(Domains ovcs);

    @Delete
    void delete(Domains ovcs);

    @Update
    void update(Domains ovcs);
}
