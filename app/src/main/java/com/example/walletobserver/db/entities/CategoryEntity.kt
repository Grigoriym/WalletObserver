package com.example.walletobserver.db.entities

import androidx.room.*

@Entity(
  tableName = "category_entity"
)
data class CategoryEntity(
  @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "cat_id") var id: Long = 0,
//  @Embedded var subCategoryEntity: SubCategoryEntity?,
  @ColumnInfo(name = "cat_name") var name: String,
  @ColumnInfo(name = "cat_icon") var icon: String
)

