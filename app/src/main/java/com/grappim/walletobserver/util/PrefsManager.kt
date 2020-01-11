package com.grappim.walletobserver.util

import android.content.Context
import android.content.Context.MODE_PRIVATE

class PrefsManager(
  val context: Context
) {

  private val pref = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
  private val editor = pref.edit()

  fun setFirstTimeLaunch(value: Boolean) =
    editor.putBoolean(PREFS_IS_IT_FIRST_TIME_LAUNCH, value).apply()

  fun isItFirstTimeLaunch(): Boolean =
    pref.getBoolean(PREFS_IS_IT_FIRST_TIME_LAUNCH, true)

}