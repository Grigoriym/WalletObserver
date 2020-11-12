package com.grappim.walletobserver.ui.debts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.grappim.walletobserver.R
import kotlinx.android.synthetic.main.fragment_debts.tlDebts
import kotlinx.android.synthetic.main.fragment_debts.vpDebts
import timber.log.Timber

class DebtsFragment : Fragment(R.layout.fragment_debts) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("DebtsFragment - onViewCreated")

        val dpa = DebtsPagerAdapter(requireActivity().supportFragmentManager)
        vpDebts.adapter = dpa
        tlDebts.setupWithViewPager(vpDebts)
    }

}
