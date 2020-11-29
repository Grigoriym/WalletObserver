package com.grappim.walletobserver.api

import com.grappim.walletobserver.BuildConfig
import com.grappim.walletobserver.entity.currencysymbols.CurrencySymbolsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FixerApi {

    @GET("symbols")
    fun getSymbols(
        @Query("access_key") accessKey: String = BuildConfig.FIXER_API_KEY
    ): CurrencySymbolsResponse

}