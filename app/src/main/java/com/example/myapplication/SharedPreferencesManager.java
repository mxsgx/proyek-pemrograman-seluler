package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SharedPreferencesManager(Context context) {
        sharedPreferences = context.getSharedPreferences("com.example.myapplication", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        setDefaultValue();
    }

    private void setDefaultValue() {
        setEmail("admin@example.com");
        setPassword("password");
    }

    private void setEmail(String email) {
        editor.putString("email", email).apply();
    }

    private void setPassword(String password) {
        editor.putString("password", password).apply();
    }

    public void login() {
        editor.putBoolean("is_logged_in", true).apply();
    }

    public void logout() {
        editor.putBoolean("is_logged_in", false).apply();
    }

    public String getEmail() {
        return sharedPreferences.getString("email", "");
    }

    public String getPassword() {
        return sharedPreferences.getString("password", "");
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean("is_logged_in", false);
    }
}
