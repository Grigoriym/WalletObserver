package com.grappim.walletobserver.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.grappim.walletobserver.db.AppDatabase
import com.grappim.walletobserver.db.dao.CategoryDAO
import com.grappim.walletobserver.db.dao.RecordDAO
import com.grappim.walletobserver.db.dao.SubCategoryDao
import com.grappim.walletobserver.util.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
@InstallIn(ApplicationModule::class)
object DatabaseModule {

  @Provides
  @Singleton
  fun provideRoom(
    applicationContext: Context
  ): RoomDatabase =
    Room.databaseBuilder(
      applicationContext,
      AppDatabase::class.java,
      DB_NAME
    ).build()

  @Provides
  fun provideCategoryDao(
    database: AppDatabase
  ): CategoryDAO = database.categoryDao()

  @Provides
  fun provideRecordDao(
    database: AppDatabase
  ): RecordDAO = database.recordDao()

  @Provides
  fun providerSubcategoryDao(
    database: AppDatabase
  ): SubCategoryDao = database.subCategoryDao()
}