package com.grappim.walletobserver.ui.records

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.grappim.walletobserver.R
import kotlinx.android.synthetic.main.fragment_records.*
import timber.log.Timber

class RecordsFragment : Fragment(R.layout.fragment_records) {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    Timber.d("RecordsFragment - onViewCreated")

    fabRecords.setOnClickListener {
      findNavController().navigate(RecordsFragmentDirections.nextFragment())
    }
  }

}
