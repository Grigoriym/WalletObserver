package com.example.walletobserver.ui.add_record

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.walletobserver.R
import com.example.walletobserver.databinding.FragmentAddRecordNewBinding
import com.example.walletobserver.util.GlideApp
import kotlinx.android.synthetic.main.fragment_add_record.*
import org.koin.core.KoinComponent
import org.koin.core.inject
import timber.log.Timber

class AddRecordFragment : Fragment(), KoinComponent {

  private val viewModelFactory: AddRecordViewModelFactory by inject()
  private val viewModel by viewModels<AddRecordViewModel> { viewModelFactory }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? = FragmentAddRecordNewBinding.inflate(
    inflater,
    container,
    false
  ).apply {
    lifecycleOwner = this@AddRecordFragment
    viewModel = this@AddRecordFragment.viewModel
  }.root

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    Timber.d("AddRecordFragment - onViewCreated")

//    checkIv()
//    initButtons()
//    initViews()

    newInit()
  }

  private fun newInit() {
    viewModel.apply {
      result.observe(this@AddRecordFragment,
        Observer{
          Timber.d("Observer result - ${result.value}")
        })
      currentExpression.observe(this@AddRecordFragment,
        Observer {
          Timber.d("Observer currentExpression - ${currentExpression.value}")
        })
    }
  }

  private fun checkIv() {
    if (ivAddRecordType.id == R.drawable.ic_add_24dp) {
      btnAddRecordExpense.isEnabled = false
      btnAddRecordIncome.isEnabled = true
    } else {
      btnAddRecordExpense.isEnabled = true
      btnAddRecordIncome.isEnabled = false
    }
  }

  private fun initViews() {
    btnAddRecordIncome.setOnClickListener {
      btnAddRecordExpense.isEnabled = true
      btnAddRecordIncome.isEnabled = false
      GlideApp.with(this)
        .load(ContextCompat.getDrawable(this.context!!, R.drawable.ic_add_24dp))
        .into(ivAddRecordType)
    }
    btnAddRecordExpense.setOnClickListener {
      btnAddRecordExpense.isEnabled = false
      btnAddRecordIncome.isEnabled = true
      GlideApp.with(this)
        .load(ContextCompat.getDrawable(this.context!!, R.drawable.ic_remove_24dp))
        .into(ivAddRecordType)
    }

    llAddRecordCategory.setOnClickListener {
      findNavController().navigate(AddRecordFragmentDirections.nextFragment())
    }

    tvAddRecordLLCategory.text = "None"
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
