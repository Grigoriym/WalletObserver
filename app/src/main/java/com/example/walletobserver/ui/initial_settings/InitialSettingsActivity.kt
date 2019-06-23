package com.example.walletobserver.ui.initial_settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.walletobserver.R
import com.example.walletobserver.ui.MainActivity
import com.example.walletobserver.util.extensions.launchActivity
import kotlinx.android.synthetic.main.activity_initial_settings.*

class InitialSettingsActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_initial_settings)

    btnInitialSettingsNext.setOnClickListener {
      launchActivity<MainActivity> {  }
      finish()
    }
  }

}
