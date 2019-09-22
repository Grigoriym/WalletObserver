package com.grappim.walletobserver.ui.goals

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.grappim.walletobserver.ui.goals.active.ActiveGoalsFragment
import com.grappim.walletobserver.ui.goals.paused.PausedGoalsFragment
import com.grappim.walletobserver.ui.goals.reached.ReachedGoalsFragment

class GoalsPagerAdapter(
  fragmentManager: FragmentManager?
) : FragmentStatePagerAdapter(fragmentManager!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
  override fun getItem(position: Int): Fragment {
    return when (position) {
      0 -> ActiveGoalsFragment()
      1 -> PausedGoalsFragment()
      else -> ReachedGoalsFragment()
    }
  }

  override fun getCount(): Int = 3

  override fun getPageTitle(position: Int): CharSequence? {
    return when (position) {
      0 -> "Active"
      1 -> "Paused"
      else -> "Reached"
    }
  }

}