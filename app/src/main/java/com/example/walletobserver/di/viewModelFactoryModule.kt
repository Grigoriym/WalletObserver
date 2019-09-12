package com.example.walletobserver.di

import com.example.walletobserver.ui.add_record.AddRecordViewModelFactory
import com.example.walletobserver.ui.choose_category.ChooseCategoryViewModelFactory
import com.example.walletobserver.ui.choose_category.choose_subcategory.ChooseSubcategoryViewModelFactory
import com.example.walletobserver.util.KOIN_CATEGORY_REPO
import com.example.walletobserver.util.KOIN_SUBCATEGORY_REPO
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelFactoryModule = module {
  factory { AddRecordViewModelFactory() }
  factory { ChooseCategoryViewModelFactory(get(named(KOIN_CATEGORY_REPO))) }
  factory { ChooseSubcategoryViewModelFactory(get(named(KOIN_SUBCATEGORY_REPO))) }
}