package com.example.walletobserver.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
  tableName = "sub_category_name",
  foreignKeys = [ForeignKey(
    entity = RecordEntity::class,
    parentColumns = ["cat_id"],
    childColumns = ["sub_cat_id"],
    onDelete = ForeignKey.CASCADE
  )]
)
data class SubCategoryEntity(
  @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "sub_cat_id") var id: Long = 0,
  @ColumnInfo(name = "sub_cat_name") var name: String,
  @ColumnInfo(name = "sub_cat_icon") var icon: String
)