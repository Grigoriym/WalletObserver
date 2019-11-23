package com.grappim.walletobserver.di

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.grappim.walletobserver.db.AppDatabase
import com.grappim.walletobserver.db.dao.CategoryDAO
import com.grappim.walletobserver.db.dao.SubCategoryDao
import com.grappim.walletobserver.db.listOfCategories
import com.grappim.walletobserver.db.listOfSubCategories00
import com.grappim.walletobserver.db.listOfSubCategories01
import com.grappim.walletobserver.util.*
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
      AppDatabase::class.java, DB_NAME
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
              listOfCategories.also {
                for (i in it.indices) {
                  when (i) {
                    0 -> {
                      get<SubCategoryDao>(named(KOIN_SUB_CATEGORY_DAO))
                        .insertSubCategoriesForCategory(it[0], listOfSubCategories00)
                    }
                    1 -> {
                      get<SubCategoryDao>(named(KOIN_SUB_CATEGORY_DAO))
                        .insertSubCategoriesForCategory(it[1], listOfSubCategories01)
                    }
                  }
                }
              }
            )
        }
      }
    }
  }

  single(named(KOIN_CATEGORY_DAO)) { get<AppDatabase>(named(KOIN_APP_DB)).categoryDao() }
  single(named(KOIN_RECODR_DAO)) { get<AppDatabase>(named(KOIN_APP_DB)).recordDao() }
  single(named(KOIN_SUB_CATEGORY_DAO)) { get<AppDatabase>(named(KOIN_APP_DB)).subCategoryDao() }
}