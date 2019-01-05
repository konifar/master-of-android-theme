package com.coubic.bookings.debug.timber

import android.util.Log
import com.crashlytics.android.Crashlytics
import timber.log.Timber

class CrashlyticsTimberTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        when (priority) {
            Log.DEBUG, Log.VERBOSE, Log.INFO, Log.WARN -> return
            else -> {
                if (t != null) {
                    Crashlytics.logException(t)
                } else {
                    Crashlytics.logException(RuntimeException(message))
                }
            }
        }
    }
}