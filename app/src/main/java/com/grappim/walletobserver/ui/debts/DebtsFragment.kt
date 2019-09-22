package com.grappim.walletobserver.ui.debts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.grappim.walletobserver.R
import kotlinx.android.synthetic.main.fragment_debts.*
import timber.log.Timber

class DebtsFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? =
    inflater.inflate(R.layout.fragment_debts, container, false)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    Timber.d("DebtsFragment - onViewCreated")

    val dpa = DebtsPagerAdapter(activity?.supportFragmentManager)
    vpDebts.adapter = dpa
    tlDebts.setupWithViewPager(vpDebts)
  }

}
