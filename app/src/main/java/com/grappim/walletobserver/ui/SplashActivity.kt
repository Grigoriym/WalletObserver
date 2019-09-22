package com.grappim.walletobserver.ui

import androidx.appcompat.app.AppCompatActivity
import com.grappim.walletobserver.ui.intro.IntroActivity
import com.grappim.walletobserver.util.PrefsManager
import com.grappim.walletobserver.util.extensions.launchActivity
import org.koin.core.KoinComponent
import org.koin.core.inject

class SplashActivity : AppCompatActivity(), KoinComponent {

  private val prefs: PrefsManager by inject()

  override fun onResume() {
    super.onResume()
    prefs.setFirstTimeLaunch(true)//todo needs to be deleted eventually
    if (!prefs.isItFirstTimeLaunch()) {
      this.launchActivity<MainActivity> { }
    } else {
      this.launchActivity<IntroActivity> { }
    }
    finish()
  }
}
