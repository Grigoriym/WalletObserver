package com.example.walletobserver.di

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.walletobserver.db.AppDatabase
import com.example.walletobserver.db.entities.CategoryEntity
import com.example.walletobserver.util.KOIN_APP_DB
import com.example.walletobserver.util.KOIN_CATEGORY_DAO
import com.example.walletobserver.util.KOIN_RECODR_DAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module
import java.util.*

val dbModule = module {
  single(named(KOIN_APP_DB)) {
    Room.databaseBuilder(
      androidApplication(),
      AppDatabase::class.java, "wallet-observer.db"
    )
      .addCallback(
        get(named("dbCallback"))
      )
      .build()
  }

  single(named("dbCallback")) {
    object : RoomDatabase.Callback() {
      override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        CoroutineScope(Dispatchers.IO).launch {
          get<AppDatabase>(named("appDb")).categoryDao().insertListOfCategories(
            listOf(
              CategoryEntity.dummyObject(),
              CategoryEntity.dummyObject()
            )
          )
        }
      }
    }
  }

  single(named(KOIN_CATEGORY_DAO)) { get<AppDatabase>(named(KOIN_APP_DB)).categoryDao() }
  single(named(KOIN_RECODR_DAO)) { get<AppDatabase>(named(KOIN_APP_DB)).recordDao() }
}