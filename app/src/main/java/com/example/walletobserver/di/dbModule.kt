package com.example.walletobserver.di

import androidx.room.Room
import com.example.walletobserver.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dbModule = module {
  single(named("appDb")) {
    Room.databaseBuilder(
      androidApplication(),
      AppDatabase::class.java, "wallet-observer.db"
    )
      .build()
  }

  single { get<AppDatabase>(named("appDb")).categoryDao() }
}