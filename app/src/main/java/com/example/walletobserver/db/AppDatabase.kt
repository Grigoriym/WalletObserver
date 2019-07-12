package com.example.walletobserver.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.walletobserver.db.dao.RecordDAO
import com.example.walletobserver.db.entities.RecordEntity

@Database(entities = arrayOf(RecordEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
  abstract fun recordDao(): RecordDAO
}