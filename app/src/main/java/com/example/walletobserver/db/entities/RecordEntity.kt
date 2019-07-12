package com.example.walletobserver.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "record_entity")
data class RecordEntity(
  @PrimaryKey @ColumnInfo(name = "id") val recordId: String = UUID.randomUUID().toString(),
//  val categoryEntity: CategoryEntity? = null,
//  val recordTypeEntity: RecordTypeEntity? = null,
  val amount: Double? = null,
  val currency: String? = null,
  val note: String? = null,
  val payee: String? = null
)

//https://android.jlelse.eu/android-room-using-kotlin-f6cc0a05bf23