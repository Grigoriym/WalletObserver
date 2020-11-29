package com.grappim.walletobserver.ui.intro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.grappim.walletobserver.R
import com.grappim.walletobserver.core.extensions.launchActivity
import com.grappim.walletobserver.core.storage.PrefsManager
import com.grappim.walletobserver.databinding.ActivityIntroBinding
import com.grappim.walletobserver.ui.initial_settings.InitialSettingsActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_intro.vpIntro
import javax.inject.Inject

@AndroidEntryPoint
class IntroActivity : AppCompatActivity(R.layout.activity_intro) {

    @Inject
    lateinit var prefsManager: PrefsManager

    private val viewBinding: ActivityIntroBinding by viewBinding(
        ActivityIntroBinding::bind,
        R.id.introContainer
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        val ipa = IntroPagerAdapter(this)
        viewBinding.vpIntro.adapter = ipa
        viewBinding.wormDotsIndicator.setViewPager2(vpIntro)

        viewBinding.btnIntroSkip.setOnClickListener {
            finishIntro()
        }
    }

    private fun finishIntro() {
        prefsManager.setFirstTimeLaunch(false)
        launchActivity<InitialSettingsActivity> { }
        finish()
    }
}
