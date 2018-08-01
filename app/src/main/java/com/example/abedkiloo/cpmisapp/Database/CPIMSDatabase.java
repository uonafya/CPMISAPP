package com.example.abedkiloo.cpmisapp.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {CBOs.class}, version = 1)
public abstract  class CPIMSDatabase extends RoomDatabase {
    public abstract  CBOsDAO cbOsDAO();
}
