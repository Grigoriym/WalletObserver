package com.example.walletobserver.di

import com.example.walletobserver.util.PrefsManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val utilModule = module {
  single { PrefsManager(androidContext()) }
}