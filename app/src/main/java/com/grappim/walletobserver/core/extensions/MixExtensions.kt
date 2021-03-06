package com.grappim.walletobserver.core.extensions

import android.content.Context
import android.content.Intent

inline fun <reified T : Any> newIntent(context: Context): Intent =
    Intent(context, T::class.java)