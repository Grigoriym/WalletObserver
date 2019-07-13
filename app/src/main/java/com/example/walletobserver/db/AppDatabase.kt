package com.example.walletobserver.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.walletobserver.db.dao.RecordDAO
import com.example.walletobserver.db.entities.RecordEntity

@Database(
  entities = [RecordEntity::class],
  version = 1
)
abstract class AppDatabase : RoomDatabase() {
  abstract fun recordDao(): RecordDAO

  companion object {
    @Volatile
    private var instance: AppDatabase? = null
    private val LOCK = Any()

    operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
      instance ?: buildDatabase(context).also { instance = it }
    }

    private fun buildDatabase(context: Context) = Room.databaseBuilder(
      context,
      AppDatabase::class.java, "wallet-observer.db"
    )
      .build()
  }
}