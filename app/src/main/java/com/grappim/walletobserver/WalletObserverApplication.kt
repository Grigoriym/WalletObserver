package com.grappim.walletobserver

import android.app.Application
import com.grappim.walletobserver.di.dbModule
import com.grappim.walletobserver.di.repositoryModule
import com.grappim.walletobserver.di.utilModule
import com.grappim.walletobserver.di.viewModelFactoryModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

@HiltAndroidApp
class WalletObserverApplication : Application() {

  override fun onCreate() {
    super.onCreate()
    timberInit()
    initKoin()
  }

  private fun timberInit() {
    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }

  private fun initKoin() {
//    startKoin {
//      androidContext(this@WalletObserverApplication)
//      modules(
//        listOf(
//          utilModule,
//          viewModelFactoryModule,
//          dbModule,
//          repositoryModule
//        )
//      )
//    }
  }
}