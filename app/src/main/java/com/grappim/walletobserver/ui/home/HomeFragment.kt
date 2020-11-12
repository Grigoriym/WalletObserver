package com.grappim.walletobserver.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.grappim.walletobserver.R
import com.grappim.walletobserver.core.extensions.setSafeOnClickListener
import kotlinx.android.synthetic.main.fragment_home.fabHome
import timber.log.Timber

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("HomeFragment - onViewCreated")

        fabHome.setSafeOnClickListener {
            findNavController().navigate(HomeFragmentDirections.nextFragment())
        }
    }

}
