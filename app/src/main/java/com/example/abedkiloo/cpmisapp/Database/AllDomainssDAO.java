package com.example.abedkiloo.cpmisapp.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.abedkiloo.cpmisapp.OVC_CARE_Forms.Fragments.Form1A.Domains;
import com.example.abedkiloo.cpmisapp.OVC_CARE_Forms.Fragments.Form1A.OVCServices;
import com.example.abedkiloo.cpmisapp.Utils.Form1A.Domains.AllDomainsResuts;

import java.util.List;

@Dao
public interface AllDomainssDAO {
    @Query("SELECT * FROM AllDomainsTable")
    List<AllDomainsTable> getAll();


    @Query("SELECT * FROM AllDomainsTable")
    List<AllDomainsResuts> getAllServices();

    @Query("SELECT * FROM AllDomainsTable")
    List<Domains> getDomains();

    @Query("SELECT * FROM Services")
    List<OVCServices> getService();

    @Insert
    void insert(AllDomainsTable allDomainsTable);

    @Delete
    void delete(AllDomainsTable allDomainsTable);

    @Update
    void update(AllDomainsTable allDomainsTable);
}
