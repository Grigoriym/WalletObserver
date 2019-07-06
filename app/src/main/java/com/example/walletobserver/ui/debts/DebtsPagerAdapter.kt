package com.example.walletobserver.ui.debts

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.walletobserver.ui.debts.active.ActiveDebtsFragment
import com.example.walletobserver.ui.debts.closed.ClosedDebtsFragment

class DebtsPagerAdapter(
  fragmentManger: FragmentManager?
) : FragmentStatePagerAdapter(fragmentManger!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
  override fun getItem(position: Int): Fragment {
    return when (position) {
      0 -> ActiveDebtsFragment()
      else -> ClosedDebtsFragment()
    }
  }

  override fun getCount(): Int = 2

  override fun getPageTitle(position: Int): CharSequence? {
    return when (position) {
      0 -> "Active"
      else -> "Closed"
    }
  }
}