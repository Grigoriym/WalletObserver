package com.grappim.walletobserver.repository

import androidx.lifecycle.LiveData
import com.grappim.walletobserver.db.dao.CategoryDAO
import com.grappim.walletobserver.db.entities.CategoryEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryRepository(
  private val categoryDao: CategoryDAO
) {

  private val allCategories: LiveData<List<CategoryEntity>> = categoryDao.getAllCategories()

  fun getAllCategories() = allCategories


  suspend fun insertCategories(categories: List<CategoryEntity>) =
    withContext(Dispatchers.IO) {
      categoryDao.insertList(categories)
    }

  suspend fun deleteCategory(category: CategoryEntity) =
    withContext(Dispatchers.IO) {
      categoryDao.delete(category)
    }
}