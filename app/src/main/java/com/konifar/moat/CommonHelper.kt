package com.konifar.moat

import android.content.Context
import android.net.Uri
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.browser.customtabs.CustomTabsIntent

object CommonHelper {

    private const val REPOSITORY_URL = "https://github.com/konifar/master-of-android-theme"

    fun showGitHubRepository(context: Context) {
        showBrowser(context, REPOSITORY_URL)
    }

    fun changeDarkMode(activity: AppCompatActivity, darkMode: Boolean) {
        Handler().postDelayed({
            activity.delegate.setLocalNightMode(if (darkMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO)
        }, 200)
    }

    private fun showBrowser(context: Context, url: String) {
        CustomTabsIntent.Builder()
            .setShowTitle(true)
            .build()
            .launchUrl(context, Uri.parse(url))
    }

}