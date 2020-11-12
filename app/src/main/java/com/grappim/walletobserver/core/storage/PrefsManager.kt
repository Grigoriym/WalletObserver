package com.grappim.walletobserver.core.storage

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.grappim.walletobserver.core.utils.PREFS_IS_IT_FIRST_TIME_LAUNCH
import com.grappim.walletobserver.core.utils.PREFS_NAME
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PrefsManager @Inject constructor(
    @ApplicationContext val context: Context
) {

    private val pref = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
    private val editor = pref.edit()

    fun setFirstTimeLaunch(value: Boolean) =
        editor.putBoolean(PREFS_IS_IT_FIRST_TIME_LAUNCH, value).apply()

    fun isItFirstTimeLaunch(): Boolean =
        pref.getBoolean(PREFS_IS_IT_FIRST_TIME_LAUNCH, true)

}