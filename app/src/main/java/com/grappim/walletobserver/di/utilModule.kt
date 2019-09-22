package com.grappim.walletobserver.di

import com.grappim.walletobserver.util.PrefsManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val utilModule = module {
  single { PrefsManager(androidContext()) }
}