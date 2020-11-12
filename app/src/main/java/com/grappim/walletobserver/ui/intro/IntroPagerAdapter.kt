package com.grappim.walletobserver.ui.intro

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class IntroPagerAdapter(
  fragmentManager: FragmentManager
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
          0 -> IntroFirstFragment()
          1 -> IntroSecondFragment()
          2 -> IntroThirdFragment()
            else -> IntroFourthFragment()
        }
    }

    override fun getCount(): Int = 4

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
          0 -> "First"
          1 -> "Second"
          2 -> "Third"
            else -> "Fourth"
        }
    }
}