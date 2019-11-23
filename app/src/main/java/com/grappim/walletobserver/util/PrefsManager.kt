package com.grappim.walletobserver.util

import android.content.Context

class PrefsManager(
  val context: Context
) {

  private val pref = context.getSharedPreferences("welcome", 0)
  private val editor = pref.edit()

  fun setFirstTimeLaunch(isItFirstTime: Boolean) =
    editor.putBoolean("isItFirstTimeLaunch", isItFirstTime).apply()


  fun isItFirstTimeLaunch(): Boolean =
    pref.getBoolean("isItFirstTimeLaunch", true)

}