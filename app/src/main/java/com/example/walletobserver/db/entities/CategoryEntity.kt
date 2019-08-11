package com.example.walletobserver.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
  tableName = "category_table"
)
data class CategoryEntity(
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "category_id")
  val id: Long? = 0,
  @ColumnInfo(name = "category_name") val name: String?,
  @ColumnInfo(name = "category_icon") val icon: String? = ""
) {
  companion object {
    fun dummyObject() = CategoryEntity(
      name = "",
      icon = ""
    )
  }
}

