package com.example.walletobserver.di

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.walletobserver.db.AppDatabase
import com.example.walletobserver.db.dao.CategoryDAO
import com.example.walletobserver.db.listOfCategories
import com.example.walletobserver.util.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dbModule = module {
  single(named(KOIN_APP_DB)) {
    Room.databaseBuilder(
      androidApplication(),
      AppDatabase::class.java, "wallet-observer.db"
    )
      .addCallback(
        get(named(KOIN_DB_CATEGORIES_PRE_POPULATE))
      )
      .build()
  }

  single(named(KOIN_DB_CATEGORIES_PRE_POPULATE)) {
    object : RoomDatabase.Callback() {
      override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        CoroutineScope(Dispatchers.IO).launch {
          get<CategoryDAO>(named(KOIN_CATEGORY_DAO))
            .insertList(
              listOfCategories
            )
        }
      }
    }
  }

  single(named(KOIN_CATEGORY_DAO)) { get<AppDatabase>(named(KOIN_APP_DB)).categoryDao() }
  single(named(KOIN_RECODR_DAO)) { get<AppDatabase>(named(KOIN_APP_DB)).recordDao() }
  single(named(KOIN_SUB_CATEGORY_DAO)) { get<AppDatabase>(named(KOIN_APP_DB)).subCategoryDao() }
}