package com.grappim.walletobserver.core.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.grappim.walletobserver.core.db.entities.RecordEntity

@Dao
interface RecordDAO {

  @Query("SELECT * FROM record_table")
  fun getAllRecords(): LiveData<List<RecordEntity>>

  @Query("SELECT * FROM record_table WHERE record_id = :recordId")
  fun getRecordById(recordId: String): LiveData<RecordEntity>

  @Insert
  fun insertRecords(records: List<RecordEntity>)

  @Insert
  fun insertRecord(record: RecordEntity)

  @Delete
  fun deleteRecord(record: RecordEntity)

  @Update
  fun updateRecord(vararg records: RecordEntity)
}