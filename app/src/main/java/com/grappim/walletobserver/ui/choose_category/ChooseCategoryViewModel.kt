package com.grappim.walletobserver.ui.choose_category

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grappim.walletobserver.db.entities.CategoryEntity
import com.grappim.walletobserver.repository.CategoryRepository
import kotlinx.coroutines.launch

class ChooseCategoryViewModel(
  private val repo: CategoryRepository
) : ViewModel() {

  private var categories: LiveData<List<CategoryEntity>> = repo.getAllCategories()

  fun getAllCategories(): LiveData<List<CategoryEntity>> = categories

  fun loadCategories() {
    viewModelScope.launch {
      categories = repo.getAllCategories()
    }
  }

}