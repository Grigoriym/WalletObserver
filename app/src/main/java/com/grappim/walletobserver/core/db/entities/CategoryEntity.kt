package com.grappim.walletobserver.core.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

const val categoryEntityTable = "category_table"

@Entity(
    tableName = categoryEntityTable
)
data class CategoryEntity(
    @PrimaryKey
    @ColumnInfo(name = "category_id")
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "category_name") val name: String?,
    @ColumnInfo(name = "category_icon") val icon: String? = ""
)

