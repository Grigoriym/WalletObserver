package com.grappim.walletobserver.ui.choose_category.choose_subcategory

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grappim.walletobserver.core.db.entities.SubCategoryEntity
import kotlinx.coroutines.launch

class ChooseSubcategoryViewModel @ViewModelInject constructor(
    private val repo: SubCategoryRepository,
    @Assisted savedStateHandle: SavedStateHandle
) : ViewModel() {

    var currentCategoryID: String = ""

    private var subCategories: LiveData<List<SubCategoryEntity>> =
        repo.getSubCategoriesByCategoryId(currentCategoryID)

    fun getSubCategoriesByCategoryId(id: String): LiveData<List<SubCategoryEntity>> =
        subCategories

    fun loadSubcategories(id: String) {
        viewModelScope.launch {
            subCategories = repo.getSubCategoriesByCategoryId(id)
        }
    }
}