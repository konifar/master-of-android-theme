package com.konifar.moat

import android.app.Application
import com.coubic.bookings.debug.timber.CrashlyticsTimberTree
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric
import timber.log.Timber


open class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setUpLibraries()
    }

    private fun setUpLibraries() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashlyticsTimberTree())
        }

        Fabric.with(this, Crashlytics())
    }
}