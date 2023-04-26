package com.example.amber

import android.app.Application
import android.content.SharedPreferences
import com.example.amber.fragment.onboard.Prefs
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    private lateinit var preferences: SharedPreferences

    companion object {
        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        super.onCreate()
        preferences = this.applicationContext.getSharedPreferences("isShow", MODE_PRIVATE)
        prefs = Prefs(preferences)
    }
}