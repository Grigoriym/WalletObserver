package com.example.walletobserver.ui.records

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.example.walletobserver.R
import kotlinx.android.synthetic.main.fragment_records.*
import timber.log.Timber

class RecordsFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? =
    inflater.inflate(R.layout.fragment_records, container, false)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    Timber.d("RecordsFragment - onViewCreated")

    fabRecords.setOnClickListener {
      findNavController().navigate(RecordsFragmentDirections.nextFragment())
    }
  }

}
