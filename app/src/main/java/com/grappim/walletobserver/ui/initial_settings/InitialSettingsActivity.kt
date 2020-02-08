package com.grappim.walletobserver.ui.initial_settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.grappim.walletobserver.R
import com.grappim.walletobserver.ui.MainActivity
import com.grappim.walletobserver.util.extensions.launchActivity
import kotlinx.android.synthetic.main.activity_initial_settings.*

class InitialSettingsActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_initial_settings)

    buttonNext.setOnClickListener {
      launchActivity<MainActivity> { }
      finish()
    }
  }

}
