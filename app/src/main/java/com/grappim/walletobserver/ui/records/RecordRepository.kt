package com.grappim.walletobserver.ui.records

import androidx.lifecycle.LiveData
import com.grappim.walletobserver.core.db.dao.RecordDAO
import com.grappim.walletobserver.core.db.entities.RecordEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RecordRepository @Inject constructor(
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