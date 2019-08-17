package com.example.walletobserver.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.walletobserver.db.entities.CategoryEntity

@Dao
interface CategoryDAO {

  @Query("SELECT * FROM category_table")
  fun getAllCategories(): LiveData<List<CategoryEntity>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertList(categories: List<CategoryEntity>)

  @Update
  fun update(category: CategoryEntity)

  @Delete
  fun delete(category: CategoryEntity)

}