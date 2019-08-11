package com.example.walletobserver.db.dao

import androidx.room.*
import com.example.walletobserver.db.entities.SubCategoryEntity

@Dao
interface SubCategoryDao {

  @Insert
  fun insert(entity: SubCategoryEntity)

  @Update
  fun update(entity: SubCategoryEntity)

  @Delete
  fun delete(entity: SubCategoryEntity)

}