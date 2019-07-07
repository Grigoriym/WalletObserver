package com.example.walletobserver.ui.add_record

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.walletobserver.R
import kotlinx.android.synthetic.main.fragment_add_record.*
import timber.log.Timber

class AddRecordFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? =
    inflater.inflate(R.layout.fragment_add_record, container, false)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    Timber.d("AddRecordFragment - onViewCreated")

    initButtons()
  }

  private fun initButtons(){
    btnZeroAddRecord.setOnClickListener{
      tvAddRecord.text = "${tvAddRecord.text}0"
    }
    btnOneAddRecord.setOnClickListener {
      tvAddRecord.text = "${tvAddRecord.text}1"
    }
    btnTwoAddRecord.setOnClickListener {
      tvAddRecord.text = "${tvAddRecord.text}2"
    }
    btnDeleteAddRecord.setOnClickListener {
      tvAddRecord.text = tvAddRecord.text.dropLast(1)
    }
  }

}
