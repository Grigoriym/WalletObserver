package com.grappim.walletobserver.di

import com.grappim.walletobserver.util.PrefsManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

val utilModule = module {
  single { PrefsManager(androidContext()) }

  single {

  }
  single{DecimalFormatSymbols.getInstance()}
}