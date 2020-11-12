package com.grappim.walletobserver

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class WalletObserverApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        timberInit()
    }

    private fun timberInit() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}