package com.example.appdevproject

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.BuildCompat

class Util {
    companion object {
        fun applyPreferencedTheme(sf: SharedPreferences, context: Context) {
            when(sf.getString(context.getString(R.string.theme_pref),
                context.getString(R.string.auto_theme_pref))) {
                context.getString(R.string.dark_theme_pref) -> {
                    Log.d("TAG", "Dark mode")
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
                context.getString(R.string.light_theme_pref) -> {
                    Log.d("TAG", "Light mode")
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
                else -> {
                    if (BuildCompat.isAtLeastQ()) {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                    } else {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY);
                    }
                }
            }
        }
    }
}