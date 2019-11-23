package com.grappim.walletobserver.di.module

import android.content.Context
import com.grappim.walletobserver.util.PrefsManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DaggerModule {

  @Provides
  @Singleton
  fun providePrefsManager(contex: Context) =
    PrefsManager(contex)
}