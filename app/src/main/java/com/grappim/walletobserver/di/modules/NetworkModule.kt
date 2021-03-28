package com.grappim.walletobserver.di.modules

import com.grappim.walletobserver.BuildConfig
import com.grappim.walletobserver.api.FixerApi
import com.grappim.walletobserver.di.qualifiers.FixerApiQualifier
import com.grappim.walletobserver.di.qualifiers.FixerRetrofit
import com.grappim.walletobserver.di.qualifiers.HttpLoggingInterceptorQualifier
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitBuilder(): Retrofit.Builder =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())

    @Provides
    @Singleton
    @FixerApiQualifier
    fun providerFixerApi(
        @FixerRetrofit retrofit: Retrofit
    ): FixerApi = retrofit.create(FixerApi::class.java)

    @Provides
    @Singleton
    @FixerRetrofit
    fun providerFixerRetrofit(
        builder: Retrofit.Builder,
        client: OkHttpClient
    ): Retrofit =
        builder.baseUrl(BuildConfig.FIXER_BASE_URL)
            .client(client)
            .build()

    @Provides
    @Singleton
    fun providerOkHttpClient(
        @HttpLoggingInterceptorQualifier loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .apply {
                if (BuildConfig.DEBUG) {
                    addInterceptor(loggingInterceptor)
                }
            }
            .build()

    @Provides
    @Singleton
    @HttpLoggingInterceptorQualifier
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor { message -> Timber.tag("API").d(message) }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

}