package com.grappim.walletobserver.ui.add_record

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddRecordViewModelFactory() : ViewModelProvider.NewInstanceFactory() {
  override fun <T : ViewModel?> create(modelClass: Class<T>): T =
    AddRecordViewModel() as T
}