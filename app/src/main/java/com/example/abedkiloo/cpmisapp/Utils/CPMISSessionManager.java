package com.example.abedkiloo.cpmisapp.Utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.abedkiloo.cpmisapp.CPIMSActivities.LoginUSG;

import java.util.HashMap;

public class CPMISSessionManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;
    // Shared pref mode
    int PRIVATE_MODE = 0;
    // Context
    Context _context;


    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String KEY_USER_NAME = "username";

    // Email address (make variable public to access from outside)
    public static final String KEY_EMAIL = "email";

    // authorization
    public static final String KEY_TOKEN = "token";

    public CPMISSessionManager(Context cpmisContext) {
        this._context = cpmisContext;
        pref = _context.getSharedPreferences(Constants.CPIMS_PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    /**
     * Create login session
     */
    public void createLoginSession(String name, String email) {
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(KEY_USER_NAME, name);

        // Storing email in pref
        editor.putString(KEY_EMAIL, email);

        // Storing token in pref
        editor.putString(KEY_TOKEN, email);

        // commit changes
        editor.commit();
    }

    /**
     * Get stored session data
     */
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(KEY_USER_NAME, pref.getString(KEY_USER_NAME, null));

        // user email id
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));

   // user token
        user.put(KEY_TOKEN, pref.getString(KEY_TOKEN, null));

        // return user
        return user;
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     */
    public void checkLogin() {
        // Check login status
        if (!this.isLoggedIn()) {
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, LoginUSG.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
        }

    }

    /**
     * Quick check for login
     **/
    // Get Login State
    private boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }
}
