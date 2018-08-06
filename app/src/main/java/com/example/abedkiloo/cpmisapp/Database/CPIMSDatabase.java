package com.example.abedkiloo.cpmisapp.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {CBOs.class, OVCs.class, Domains.class, AllDomainsTable.class}, version = 1)
public abstract class CPIMSDatabase extends RoomDatabase {
    public abstract CBOsDAO cbOsDAO();

    public abstract OVCsDAO ovCsDAO();


    public abstract DomainsDAO domainsDAO();

    public abstract AllDomainssDAO allDomainssDAO();
}
