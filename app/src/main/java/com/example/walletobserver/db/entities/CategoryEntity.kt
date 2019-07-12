package com.example.walletobserver.db.entities

import androidx.room.Entity

@Entity(tableName = "category_entity")
data class CategoryEntity(
  val name: String? = null,
  val subCategoryEntity: SubCategoryEntity,
  val icon: String? = null
)