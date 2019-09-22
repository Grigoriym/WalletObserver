package com.grappim.walletobserver.ui.choose_category.choose_subcategory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.grappim.walletobserver.repository.SubCategoryRepository

class ChooseSubcategoryViewModelFactory(
  private val repo: SubCategoryRepository
) : ViewModelProvider.NewInstanceFactory() {

  override fun <T : ViewModel?> create(modelClass: Class<T>): T =
    ChooseSubcategoryViewModel(repo) as T

}