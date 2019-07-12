package com.example.walletobserver.db.dao

import androidx.room.*
import com.example.walletobserver.db.entities.RecordEntity

@Dao
interface RecordDAO {

  @Query("SELECT * FROM record_entity")
  fun getAll(): List<RecordEntity>

  @Insert
  fun insertAll(vararg record: RecordEntity)

  @Delete
  fun delete(record: RecordEntity)

  @Update
  fun updateRecord(vararg records: RecordEntity)
}