package com.grappim.walletobserver.ui.goals

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.grappim.walletobserver.ui.goals.active.ActiveGoalsFragment
import com.grappim.walletobserver.ui.goals.paused.PausedGoalsFragment
import com.grappim.walletobserver.ui.goals.reached.ReachedGoalsFragment

class GoalsPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> ActiveGoalsFragment()
            1 -> PausedGoalsFragment()
            else -> ReachedGoalsFragment()
        }

}