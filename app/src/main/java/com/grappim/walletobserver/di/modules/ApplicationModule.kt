package com.grappim.walletobserver.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import java.text.DecimalFormatSymbols
import javax.inject.Scope
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideDecimalFormatSymbols(): DecimalFormatSymbols =
        DecimalFormatSymbols()

}