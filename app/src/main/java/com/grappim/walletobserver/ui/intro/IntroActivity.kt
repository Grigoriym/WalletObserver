package com.grappim.walletobserver.ui.intro

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.grappim.walletobserver.R
import com.grappim.walletobserver.core.extensions.launchActivity
import com.grappim.walletobserver.core.storage.PrefsManager
import com.grappim.walletobserver.ui.initial_settings.InitialSettingsActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_intro.btnIntroNext
import kotlinx.android.synthetic.main.activity_intro.btnIntroSkip
import kotlinx.android.synthetic.main.activity_intro.vpIntro
import kotlinx.android.synthetic.main.activity_intro.worm_dots_indicator
import javax.inject.Inject
import kotlin.math.abs

@AndroidEntryPoint
class IntroActivity : AppCompatActivity(R.layout.activity_intro) {

    @Inject
    lateinit var prefsManager: PrefsManager

    private val pagerCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            if (position == (NUM_PAGES - 1)) {
                btnIntroNext.text = getString(R.string.intro_go_exclamation)
            } else {
                btnIntroNext.text = getString(R.string.intro_next)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        changeStatusBarColor()

        val ipa = IntroPagerAdapter(this)
        vpIntro.adapter = ipa
        vpIntro.registerOnPageChangeCallback(pagerCallback)
        worm_dots_indicator.setViewPager2(vpIntro)

        btnIntroSkip.setOnClickListener {
            finishIntro()
        }
        btnIntroNext.setOnClickListener {
            when (btnIntroNext.text) {
                getString(R.string.intro_next) -> {
                    vpIntro.setCurrentItem(getNextPossibleItemIndex(1), true)
                }
                getString(R.string.intro_go_exclamation) -> finishIntro()
            }
        }
    }

    private fun getNextPossibleItemIndex(change: Int): Int {
        val currentIndex = vpIntro.currentItem
        if (currentIndex == (NUM_PAGES - 1)) {
            return currentIndex
        }
        if (currentIndex + change < 0) {
            return 0
        }
        return abs((currentIndex + change) % NUM_PAGES)
    }

    private fun changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= 21) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun finishIntro() {
        prefsManager.setFirstTimeLaunch(false)
        launchActivity<InitialSettingsActivity> { }
        finish()
    }

    override fun onDestroy() {
        vpIntro.unregisterOnPageChangeCallback(pagerCallback)
        super.onDestroy()
    }
}
