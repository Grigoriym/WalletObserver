package com.example.walletobserver.ui.add_record

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat

import com.example.walletobserver.R
import com.example.walletobserver.util.GlideApp
import com.example.walletobserver.util.GlideModule
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
    initViews()
  }

  private fun initViews() {
    btnAddRecordIncome.setOnClickListener {
      GlideApp.with(this)
        .load(ContextCompat.getDrawable(this.context!!, R.drawable.ic_add_24dp))
        .into(ivAddRecordType)
    }
    btnAddRecordExpense.setOnClickListener {
      GlideApp.with(this)
        .load(ContextCompat.getDrawable(this.context!!, R.drawable.ic_remove_24dp))
        .into(ivAddRecordType)
    }
  }

  private fun initButtons() {
    btnZeroAddRecord.setOnClickListener {
      changeTvText("0")
    }
    btnOneAddRecord.setOnClickListener {
      changeTvText("1")
    }
    btnTwoAddRecord.setOnClickListener {
      changeTvText("2")
    }
    btnThreeAddRecord.setOnClickListener {
      changeTvText("3")
    }
    btnFourAddRecord.setOnClickListener {
      changeTvText("4")
    }
    btnFiveAddRecord.setOnClickListener {
      changeTvText("5")
    }
    btnSixAddRecord.setOnClickListener {
      changeTvText("6")
    }
    btnSevenAddRecord.setOnClickListener {
      changeTvText("7")
    }
    btnEightAddRecord.setOnClickListener {
      changeTvText("8")
    }
    btnNineAddRecord.setOnClickListener {
      changeTvText("9")
    }
    btnDeleteAddRecord.setOnClickListener {
      tvAddRecord.text = tvAddRecord.text.dropLast(1)
    }
  }

  private fun changeTvText(value: String) {
    tvAddRecord.text = "${tvAddRecord.text}$value"
  }

}
