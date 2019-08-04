package com.example.walletobserver.di

import com.example.walletobserver.ui.add_record.AddRecordViewModelFactory
import org.koin.dsl.module

val viewModelFactoryModule = module {
  factory { AddRecordViewModelFactory() }
}