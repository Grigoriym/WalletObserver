package com.example.walletobserver.db.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "record_entity")
data class RecordEntity(
  @PrimaryKey @ColumnInfo(name = "record_id") var recordId: String = UUID.randomUUID().toString(),
  @Embedded var categoryEntity: CategoryEntity,
//  val recordTypeEntity: RecordTypeEntity? = null,
  @ColumnInfo(name = "record_amount") var amount: Double,
  @ColumnInfo(name = "record_currency") var currency: String,
  @ColumnInfo(name = "record_note") var note: String,
  @ColumnInfo(name = "record_payee") var payee: String
)
