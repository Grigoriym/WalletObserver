package com.example.walletobserver.ui.intro

//https://www.androidhive.info/2016/05/android-build-intro-slider-app/
//  https://stackoverflow.com/questions/10852744/android-viewpager-prev-next-button

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.walletobserver.R
import com.example.walletobserver.ui.MainActivity
import com.example.walletobserver.util.PrefsManager
import com.example.walletobserver.util.extensions.launchActivity
import kotlinx.android.synthetic.main.activity_intro.*
import org.koin.core.KoinComponent
import org.koin.core.inject
import android.view.WindowManager
import kotlin.math.abs

class IntroActivity : AppCompatActivity(), KoinComponent {

  private val prefs: PrefsManager by inject()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_intro)

    init()
  }

  private fun init() {
    changeStatusBarColor()

    val ipa = IntroPagerAdapter(supportFragmentManager)
    vpIntro.adapter = ipa
    vpIntro.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
      override fun onPageSelected(position: Int) {

      }

      override fun onPageScrollStateChanged(state: Int) {

      }

      override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

      }
    })

    btnIntroSkip.setOnClickListener {
      finishIntro()
    }
    btnIntroNext.setOnClickListener {

    }
  }

  private fun addBottomDots(position: Int) {
    val colorsActive = arrayOf(resources.getIntArray(R.array.array_dot_active))
    val colorsInactive = arrayOf(resources.getIntArray(R.array.array_dot_inactive))

//    llIntro.removeAllViews()
  }

//  change this
  private fun getNextPossibleItemIndex(change: Int): Int {
    val currentIndex = vpIntro.currentItem
    val total = vpIntro.adapter?.count ?: 1
    if (currentIndex + change < 0) {
      return 0
    }
    return abs((currentIndex + change) % total)
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
//    prefs.setFirstTimeLaunch(false)
    launchActivity<MainActivity> { }
    finish()
  }
}
