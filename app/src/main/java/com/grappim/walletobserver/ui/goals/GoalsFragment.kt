package com.grappim.walletobserver.ui.goals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.grappim.walletobserver.R
import kotlinx.android.synthetic.main.fragment_goals.*
import timber.log.Timber

class GoalsFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? =
    inflater.inflate(R.layout.fragment_goals, container, false)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    Timber.d("GoalsFragment - OnViewCreated")
    val gpa = GoalsPagerAdapter(activity?.supportFragmentManager)
    vpGoals.adapter = gpa
    tlGoals.setupWithViewPager(vpGoals)
  }

}
