package com.example.walletobserver.db.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(
  tableName = "category_table"
)
data class CategoryEntity(
  @PrimaryKey
  @ColumnInfo(name = "category_id") val id: String = UUID.randomUUID().toString(),
  @ColumnInfo(name = "category_name") val name: String?,
  @ColumnInfo(name = "category_icon") val icon: String?,
  @Embedded(prefix = "sub_") val subCategory: SubCategoryEntity?
) {
  companion object {
    fun dummyObject() = CategoryEntity(
      name = "",
      icon = "",
      subCategory = SubCategoryEntity.dummyObject()
    )
  }
}

