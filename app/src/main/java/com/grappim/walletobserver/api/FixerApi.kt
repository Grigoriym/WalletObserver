package com.grappim.walletobserver.api

import retrofit2.http.GET

interface FixerApi {

    @GET("symbols")
    fun getSymbols()

}