package com.grappim.walletobserver.ui.choose_category

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grappim.walletobserver.core.db.entities.CategoryEntity
import kotlinx.coroutines.launch

class ChooseCategoryViewModel @ViewModelInject constructor(
    private val repo: CategoryRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var categories: LiveData<List<CategoryEntity>> = repo.getAllCategories()

    fun getAllCategories(): LiveData<List<CategoryEntity>> = categories

    fun loadCategories() {
        viewModelScope.launch {
            categories = repo.getAllCategories()
        }
    }

}