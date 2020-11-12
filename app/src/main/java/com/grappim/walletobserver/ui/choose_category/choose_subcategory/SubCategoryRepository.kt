package com.grappim.walletobserver.ui.choose_category.choose_subcategory

import androidx.lifecycle.LiveData
import com.grappim.walletobserver.core.db.dao.SubCategoryDao
import com.grappim.walletobserver.core.db.entities.SubCategoryEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SubCategoryRepository @Inject constructor(
  private val subCategoryDao: SubCategoryDao
) {

    private val allSubCategories: LiveData<List<SubCategoryEntity>> =
        subCategoryDao.getAllSubCategories()

    fun getAllSubCategories() = allSubCategories

    fun getSubCategoriesByCategoryId(id: String): LiveData<List<SubCategoryEntity>> =
        subCategoryDao.getSubCategoriesForCategory(id)

    suspend fun insertSubCategories(subCategories: List<SubCategoryEntity>) =
        withContext(Dispatchers.IO) {
            subCategoryDao.insertList(subCategories)
        }

    suspend fun deleteSubCategory(subCategory: SubCategoryEntity) =
        withContext(Dispatchers.IO) {
            subCategoryDao.delete(subCategory)
        }
}