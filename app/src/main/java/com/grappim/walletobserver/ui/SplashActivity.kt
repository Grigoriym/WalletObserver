package com.grappim.walletobserver.ui

import androidx.appcompat.app.AppCompatActivity
import com.grappim.walletobserver.core.extensions.launchActivity
import com.grappim.walletobserver.core.storage.PrefsManager
import com.grappim.walletobserver.ui.intro.IntroActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var prefs: PrefsManager

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
