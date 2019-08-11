package com.example.walletobserver.db.dao

import androidx.lifecycle.LiveData
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

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  fun addRecordCategory(entity: DbDataHolder.RecordCategoryEntity)

  @Query("DELETE FROM record_category_entity WHERE record=:recordId")
  fun removeAllRecordCategoiresByRecordId(recordId: Long)

  @Query("DELETE FROM record_category_entity WHERE category=:categoryId")
  fun removeAllRecordCategoriesByCategoryId(categoryId: Long)

  @Query("SELECT category_entity.category_id, category_entity.category_name, record_category_entity.category, record_entity.* FROM category_entity LEFT OUTER JOIN record_category_entity ON record_category_entity.record = category_entity.category_id LEFT OUTER JOIN record_entity ON record_category_entity.record = record_id")
  fun getAllRecordCategories(): LiveData<List<DbDataHolder.CategoryRecordPair>>
}