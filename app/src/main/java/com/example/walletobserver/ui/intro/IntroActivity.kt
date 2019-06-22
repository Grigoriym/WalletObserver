package com.example.walletobserver.ui.intro

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.viewpager.widget.ViewPager
import com.example.walletobserver.R
import com.example.walletobserver.ui.MainActivity
import com.example.walletobserver.ui.initial_settings.InitialSettingsActivity
import com.example.walletobserver.util.PrefsManager
import com.example.walletobserver.util.extensions.launchActivity
import kotlinx.android.synthetic.main.activity_intro.*
import org.koin.core.KoinComponent
import org.koin.core.inject
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
        addBottomDots(position)

        val total = vpIntro.adapter?.count ?: 1
        if (position == (total - 1)) {
          btnIntroNext.text = "Let's Go!"
        } else {
          btnIntroNext.text = "Next"
        }
      }

      override fun onPageScrollStateChanged(state: Int) {

      }

      override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

      }
    })

    addBottomDots(0)

    btnIntroSkip.setOnClickListener {
      finishIntro()
    }
    btnIntroNext.setOnClickListener {
      when (btnIntroNext.text) {
        "Next" -> {
          vpIntro.setCurrentItem(getNextPossibleItemIndex(1), true)
        }
        "Let's Go!" -> finishIntro()
      }

    }
  }

  private fun addBottomDots(position: Int) {
    val dots = arrayOfNulls<TextView>(4)
    val colorsActive = resources.getIntArray(R.array.array_dot_active)
    val colorsInactive = resources.getIntArray(R.array.array_dot_inactive)

    llIntro.removeAllViews()

    for (i in 0 until dots.size) {
      dots[i] = TextView(this)
      dots[i]?.text = HtmlCompat.fromHtml("&#8226;", HtmlCompat.FROM_HTML_MODE_LEGACY)
      dots[i]?.textSize = 35f
      dots[i]?.setTextColor(colorsInactive[position])
      llIntro.addView(dots[i])
    }
    if (dots.isNotEmpty()) {
      dots[position]?.setTextColor(colorsActive[position])
    }

  }

  private fun getNextPossibleItemIndex(change: Int): Int {
    val currentIndex = vpIntro.currentItem
    val total = vpIntro.adapter?.count ?: 1
    if (currentIndex == (total - 1)) {
      return currentIndex
    }
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
    launchActivity<InitialSettingsActivity> { }
    finish()
  }
}
