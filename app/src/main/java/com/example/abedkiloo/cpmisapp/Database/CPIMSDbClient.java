package com.example.abedkiloo.cpmisapp.Database;

import android.arch.persistence.room.Room;
import android.content.Context;

public class CPIMSDbClient {

    private Context mCtx;
    private static CPIMSDbClient mInstance;

    //our app database object
    private CPIMSDatabase appDatabase;

    private CPIMSDbClient(Context mCtx) {
        this.mCtx = mCtx;

        //creating the app database with Room database builder
        //MyToDos is the name of the database
        appDatabase = Room.databaseBuilder(mCtx, CPIMSDatabase.class, "CPIMS_Db").build();
    }

    public static synchronized CPIMSDbClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new CPIMSDbClient(mCtx);
        }
        return mInstance;
    }

    public CPIMSDatabase getAppDatabase() {
        return appDatabase;
    }
}
