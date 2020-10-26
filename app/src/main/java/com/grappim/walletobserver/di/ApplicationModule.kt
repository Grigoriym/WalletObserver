package com.grappim.walletobserver.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import java.text.DecimalFormatSymbols
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ApplicationModule {
  @Provides
  @Singleton
  fun provideDecimalFormatSymbols(): DecimalFormatSymbols =
    DecimalFormatSymbols()
}