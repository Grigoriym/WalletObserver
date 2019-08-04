package com.example.walletobserver.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.walletobserver.db.entities.CategoryEntity

@Dao
interface CategoryDAO {

  @Query("SELECT * FROM category_entity")
  fun getAllCategories(): List<CategoryEntity>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertListOfCategories(categories: List<CategoryEntity>)
}