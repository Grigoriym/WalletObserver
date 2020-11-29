package com.grappim.walletobserver

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class WalletObserverApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        timberInit()
        AndroidThreeTen.init(this)
    }

    private fun timberInit() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}