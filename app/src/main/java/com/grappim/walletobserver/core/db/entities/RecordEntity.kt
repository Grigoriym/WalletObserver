package com.grappim.walletobserver.core.db.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

const val recordEntityTable = "record_table"

@Entity(
  tableName = recordEntityTable
)
data class RecordEntity(
  @PrimaryKey
  @ColumnInfo(name = "record_id")
  val id: String = UUID.randomUUID().toString(),
  @ColumnInfo(name = "record_amount") val amount: Double?,
  @ColumnInfo(name = "record_currency") val currency: String?,
  @ColumnInfo(name = "record_note") val note: String?,
  @ColumnInfo(name = "record_payee") val payee: String?,
  @Embedded(prefix = "ctgry_") val category: CategoryEntity?
)
