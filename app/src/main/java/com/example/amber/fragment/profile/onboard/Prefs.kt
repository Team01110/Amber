package com.example.amber.fragment.onboard

import android.content.SharedPreferences

class Prefs(private val preferences: SharedPreferences) {

    fun changePreference() {
        preferences.edit().putBoolean("isShow", true).apply()
    }


    fun isShow(): Boolean {
        return preferences.getBoolean("isShow", false)
    }
}