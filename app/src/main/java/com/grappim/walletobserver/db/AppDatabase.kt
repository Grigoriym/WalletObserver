package com.grappim.walletobserver.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.grappim.walletobserver.db.dao.CategoryDAO
import com.grappim.walletobserver.db.dao.RecordDAO
import com.grappim.walletobserver.db.dao.SubCategoryDao
import com.grappim.walletobserver.db.entities.CategoryEntity
import com.grappim.walletobserver.db.entities.RecordEntity
import com.grappim.walletobserver.db.entities.SubCategoryEntity

@Database(
  entities = [
    RecordEntity::class,
    CategoryEntity::class,
    SubCategoryEntity::class
  ],
  version = 1,
  exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

  abstract fun recordDao(): RecordDAO

  abstract fun categoryDao(): CategoryDAO

  abstract fun subCategoryDao(): SubCategoryDao

}