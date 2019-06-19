package com.example.walletobserver.ui.intro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.walletobserver.R
import com.example.walletobserver.util.PrefsManager
import org.koin.core.KoinComponent
import org.koin.core.inject

class IntroActivity : AppCompatActivity(), KoinComponent {

  private val prefs: PrefsManager by inject()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_intro)
  }
}
