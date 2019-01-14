package com.konifar.moat

import android.annotation.SuppressLint
import android.content.Context

object ThemeConfigManager {

    @SuppressLint("ApplySharedPref")
    fun saveConfig(context: Context, config: ThemeConfig) {
        val pref = context.getSharedPreferences("default", Context.MODE_PRIVATE)
        pref.edit().putString(MainActivity.PREF_KEY_CONFIG, config.toString()).commit()
    }

    fun getCurrentConfig(context: Context): ThemeConfig {
        val pref = context.getSharedPreferences("default", Context.MODE_PRIVATE)
        val configString = pref.getString(MainActivity.PREF_KEY_CONFIG, ThemeConfig.CAT_ONE.toString())
        return if (configString != null) {
            ThemeConfig.valueOf(configString)
        } else {
            ThemeConfig.CAT_ONE
        }
    }
}