package com.grappim.walletobserver.ui.intro

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

const val NUM_PAGES = 4

class IntroPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> IntroFirstFragment()
            1 -> IntroSecondFragment()
            2 -> IntroThirdFragment()
            else -> IntroFourthFragment()
        }
}