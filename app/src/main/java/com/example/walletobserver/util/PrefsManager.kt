package com.example.walletobserver.util

import android.content.Context

class PrefsManager(
  val context: Context
) {

  private val pref = context.getSharedPreferences("welcome", 0)
  private val editor = pref.edit()

  fun setFirstTimeLaunch(isItFirstTime: Boolean) {
    editor.putBoolean("isItFirstTimeLaunch", isItFirstTime)
    editor.commit()
  }

  fun isItFirstTimeLaunch(): Boolean =
    pref.getBoolean("isItFirstTimeLaunch", true)

}