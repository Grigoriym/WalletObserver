package com.example.walletobserver.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.walletobserver.R
import com.example.walletobserver.util.extensions.launchActivity

class SplashActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onResume() {
    super.onResume()
    this.launchActivity<MainActivity> {  }
    finish()
  }
}
