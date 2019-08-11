package com.example.walletobserver.repository

import androidx.lifecycle.LiveData
import com.example.walletobserver.db.dao.RecordDAO
import com.example.walletobserver.db.entities.RecordEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecordRepository(
  private val recordDao: RecordDAO
) {

  private val allRecords: LiveData<List<RecordEntity>> = recordDao.getAllRecords()

  fun getAllRecords() = allRecords

  suspend fun insertRecord(record: RecordEntity) =
    withContext(Dispatchers.IO) {
      recordDao.insertRecord(record)
    }

  suspend fun deleteRecord(record: RecordEntity) =
    withContext(Dispatchers.IO) {
      recordDao.deleteRecord(record)
    }

}