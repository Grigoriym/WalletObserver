package com.grappim.walletobserver.core.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

const val SubcategoryEntityTable = "sub_category_table"

@Entity(
    tableName = SubcategoryEntityTable,
    foreignKeys = [
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["category_id"],
            childColumns = ["category_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )]
)
data class SubCategoryEntity(
    @PrimaryKey
    @ColumnInfo(name = "sub_ctgry_id")
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "sub_ctgry_name")
    val name: String?,
    @ColumnInfo(name = "sub_ctgry_icon")
    val icon: String? = "",
    @ColumnInfo(name = "category_id")
    var categoryId: String = ""
)