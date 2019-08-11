package com.example.walletobserver.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.walletobserver.db.entities.SubCategoryEntity

@Dao
interface SubCategoryDao {

  @Query("SELECT * FROM sub_ctgry_table")
  fun getAllSubCategories(): LiveData<List<SubCategoryEntity>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertList(subCategories: List<SubCategoryEntity>)

  @Update(onConflict = OnConflictStrategy.REPLACE)
  fun update(subCategory: SubCategoryEntity)

  @Delete
  fun delete(subCategory: SubCategoryEntity)

}