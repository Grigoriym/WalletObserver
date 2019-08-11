package com.example.walletobserver.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(
  tableName = "sub_ctgry_table"
)
data class SubCategoryEntity(
  @PrimaryKey
  @ColumnInfo(name = "sub_ctgry_id")
  val id: String = UUID.randomUUID().toString(),
  @ColumnInfo(name = "sub_ctgry_name")
  val name: String?,
  @ColumnInfo(name = "sub_ctgry_icon")
  val icon: String?
) {
  companion object {
    fun dummyObject() = SubCategoryEntity(
      name = "",
      icon = ""
    )
  }
}