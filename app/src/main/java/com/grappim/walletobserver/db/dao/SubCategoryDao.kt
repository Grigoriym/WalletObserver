package com.grappim.walletobserver.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.grappim.walletobserver.db.entities.CategoryEntity
import com.grappim.walletobserver.db.entities.SubCategoryEntity

@Dao
abstract class SubCategoryDao {

  fun insertSubCategoriesForCategory(
    category: CategoryEntity,
    subCategories: List<SubCategoryEntity>
  ) {
    for (item in subCategories) {
      item.categoryId = category.id
    }
  }

  @Query("SELECT * FROM sub_ctgry_table")
  abstract fun getAllSubCategories(): LiveData<List<SubCategoryEntity>>

  @Query("SELECT * FROM sub_ctgry_table WHERE category_id=:categoryId")
  abstract fun getSubCategoriesForCategory(categoryId: String): LiveData<List<SubCategoryEntity>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  abstract fun insertList(subCategories: List<SubCategoryEntity>)

  @Update(onConflict = OnConflictStrategy.REPLACE)
  abstract fun update(subCategory: SubCategoryEntity)

  @Delete
  abstract fun delete(subCategory: SubCategoryEntity)

}