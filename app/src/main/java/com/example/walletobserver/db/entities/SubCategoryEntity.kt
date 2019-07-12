package com.example.walletobserver.db.entities

import androidx.room.Entity

@Entity(tableName = "sub_category_name")
data class SubCategoryEntity(
  val name: String? = null,
  val icon: String? = null
)