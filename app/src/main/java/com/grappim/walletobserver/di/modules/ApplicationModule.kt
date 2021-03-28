package com.grappim.walletobserver.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.text.DecimalFormatSymbols
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideDecimalFormatSymbols(): DecimalFormatSymbols =
        DecimalFormatSymbols()

}