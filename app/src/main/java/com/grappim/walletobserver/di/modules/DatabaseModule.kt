package com.grappim.walletobserver.di.modules

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.grappim.walletobserver.core.db.AppDatabase
import com.grappim.walletobserver.core.db.dao.CategoryDAO
import com.grappim.walletobserver.core.db.dao.RecordDAO
import com.grappim.walletobserver.core.db.dao.SubCategoryDao
import com.grappim.walletobserver.core.utils.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideRoom(
        @ApplicationContext applicationContext: Context
    ): AppDatabase =
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