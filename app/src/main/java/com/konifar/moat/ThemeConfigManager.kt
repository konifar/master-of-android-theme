package com.konifar.moat

import android.annotation.SuppressLint
import android.content.Context

object ThemeConfigManager {

    private const val PREF_KEY_CONFIG = "pref_key_config"

    @SuppressLint("ApplySharedPref")
    fun saveConfig(context: Context, config: ThemeConfig) {
        val pref = context.getSharedPreferences("default", Context.MODE_PRIVATE)
        pref.edit().putString(PREF_KEY_CONFIG, config.toString()).commit()
    }

    fun getCurrentConfig(context: Context): ThemeConfig {
        val pref = context.getSharedPreferences("default", Context.MODE_PRIVATE)
        val configString = pref.getString(PREF_KEY_CONFIG, ThemeConfig.CAT_ONE.toString())
        return if (configString != null) {
            ThemeConfig.valueOf(configString)
        } else {
            ThemeConfig.CAT_ONE
        }
    }
}