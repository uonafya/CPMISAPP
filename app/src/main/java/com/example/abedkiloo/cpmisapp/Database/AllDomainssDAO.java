package com.example.abedkiloo.cpmisapp.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.abedkiloo.cpmisapp.Utils.Form1A.Domains.AllDomains;
import com.example.abedkiloo.cpmisapp.Utils.Form1A.Domains.AllDomainsResuts;

import java.util.List;

@Dao
public interface AllDomainssDAO {
    @Query("SELECT * FROM AllDomainsTable")
    List<AllDomainsTable> getAll();


    @Query("SELECT * FROM AllDomainsTable")
    List<AllDomainsResuts> getAllServices();

    @Insert
    void insert(AllDomainsTable allDomainsTable);

    @Delete
    void delete(AllDomainsTable allDomainsTable);

    @Update
    void update(AllDomainsTable allDomainsTable);
}