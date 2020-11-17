package com.grappim.walletobserver.ui.debts

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.grappim.walletobserver.ui.debts.active.ActiveDebtsFragment
import com.grappim.walletobserver.ui.debts.closed.ClosedDebtsFragment

class DebtsPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment =
         when (position) {
            0 -> ActiveDebtsFragment()
            else -> ClosedDebtsFragment()
        }

}