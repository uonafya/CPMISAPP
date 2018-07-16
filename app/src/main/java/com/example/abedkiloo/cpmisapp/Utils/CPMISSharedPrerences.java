package com.example.abedkiloo.cpmisapp.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class CPMISSharedPrerences {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;
    // Shared pref mode
    int PRIVATE_MODE = 0;
    // Context
    Context _context;

    public CPMISSharedPrerences(Context cpmisContext) {
        this._context = cpmisContext;
        pref = _context.getSharedPreferences(Constants.CPIMS_PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

}
