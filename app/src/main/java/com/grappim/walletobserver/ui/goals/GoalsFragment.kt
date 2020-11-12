package com.grappim.walletobserver.ui.goals

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.grappim.walletobserver.R
import kotlinx.android.synthetic.main.fragment_goals.tlGoals
import kotlinx.android.synthetic.main.fragment_goals.vpGoals
import timber.log.Timber

class GoalsFragment : Fragment(R.layout.fragment_goals) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("GoalsFragment - OnViewCreated")
        val gpa = GoalsPagerAdapter(requireActivity().supportFragmentManager)
        vpGoals.adapter = gpa
        tlGoals.setupWithViewPager(vpGoals)
    }

}
