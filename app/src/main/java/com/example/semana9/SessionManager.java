package com.example.semana9;

import android.content.Context;
import android.content.SharedPreferences;

/** Guarda quién tiene la sesión abierta, para no pedir login cada vez que se abre la app. */
public class SessionManager {

    private static final String PREFS = "session";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USERNAME = "username";

    private final SharedPreferences prefs;

    public SessionManager(Context context) {
        prefs = context.getApplicationContext()
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public void saveSession(long userId, String username) {
        prefs.edit().putLong(KEY_USER_ID, userId).putString(KEY_USERNAME, username).apply();
    }

    public boolean isLoggedIn() {
        return prefs.getLong(KEY_USER_ID, -1) != -1;
    }

    public String getUsername() {
        return prefs.getString(KEY_USERNAME, "");
    }

    public void logout() {
        prefs.edit().clear().apply();
    }
}
