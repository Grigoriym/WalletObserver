package com.example.walletobserver.util

import android.content.Context
import android.content.SharedPreferences

class PrefsManager(
  val context: Context
) {

  val pref = context.getSharedPreferences("welcome", 0)
  val editor = pref.edit()

  fun setFirstTimeLaunch(isItFirstTime: Boolean) {
    editor.putBoolean("isItFirstTimeLaunch", isItFirstTime)
    editor.commit()
  }

  fun isItFirstTimeLaunch(): Boolean =
    pref.getBoolean("isItFirstTimeLaunch", true)

}