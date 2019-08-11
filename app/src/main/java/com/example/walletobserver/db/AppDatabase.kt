package com.example.walletobserver.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.walletobserver.db.dao.CategoryDAO
import com.example.walletobserver.db.dao.RecordDAO
import com.example.walletobserver.db.dao.SubCategoryDao
import com.example.walletobserver.db.entities.CategoryEntity
import com.example.walletobserver.db.entities.RecordEntity
import com.example.walletobserver.db.entities.SubCategoryEntity

@Database(
  entities = [
    RecordEntity::class,
    CategoryEntity::class,
    SubCategoryEntity::class,
    DbDataHolder.RecordCategoryEntity::class
  ],
  version = 1,
  exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

  abstract fun recordDao(): RecordDAO

  abstract fun categoryDao(): CategoryDAO

  abstract fun subCategoryDao(): SubCategoryDao

}