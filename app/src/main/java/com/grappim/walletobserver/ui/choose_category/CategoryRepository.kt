package com.grappim.walletobserver.ui.choose_category

import androidx.lifecycle.LiveData
import com.grappim.walletobserver.core.db.dao.CategoryDAO
import com.grappim.walletobserver.core.db.entities.CategoryEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryRepository @Inject constructor(
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