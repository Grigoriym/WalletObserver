package com.grappim.walletobserver.ui.initial_settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.grappim.walletobserver.R
import com.grappim.walletobserver.core.extensions.launchActivity
import com.grappim.walletobserver.core.extensions.setSafeOnClickListener
import com.grappim.walletobserver.ui.MainActivity
import kotlinx.android.synthetic.main.activity_initial_settings.buttonNext

class InitialSettingsActivity : AppCompatActivity(R.layout.activity_initial_settings) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        buttonNext.setSafeOnClickListener {
            launchActivity<MainActivity> { }
            finish()
        }
    }

}
