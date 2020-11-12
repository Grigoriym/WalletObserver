package com.grappim.walletobserver.ui.add_record

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.grappim.walletobserver.R
import com.grappim.walletobserver.core.extensions.setSafeOnClickListener
import kotlinx.android.synthetic.main.fragment_add_record_new.llAddRecordCategory
import kotlinx.android.synthetic.main.fragment_add_record_new.tvAddRecordLLCategory
import timber.log.Timber

class AddRecordFragment : Fragment(R.layout.fragment_add_record_new) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("AddRecordFragment - onViewCreated")
        initViews()
    }

    private fun initViews() {
        llAddRecordCategory.setSafeOnClickListener {
            findNavController().navigate(AddRecordFragmentDirections.nextFragment())
        }
        tvAddRecordLLCategory.text = getString(R.string.title_none)
    }

}
