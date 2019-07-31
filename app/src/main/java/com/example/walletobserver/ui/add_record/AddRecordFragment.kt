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
import com.example.walletobserver.util.extensions.showSnackbar
import kotlinx.android.synthetic.main.fragment_add_record.*
import kotlinx.android.synthetic.main.fragment_add_record.llAddRecordCategory
import kotlinx.android.synthetic.main.fragment_add_record.tvAddRecordLLCategory
import kotlinx.android.synthetic.main.fragment_add_record_new.*
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

    newInit()
  }

  private fun newInit() {
    viewModel.apply {
      result.observe(this@AddRecordFragment,
        Observer {
          Timber.d("Observer result - ${result.value}")
        })
      currentExpression.observe(this@AddRecordFragment,
        Observer {
          Timber.d("Observer currentExpression - ${currentExpression.value}")
        })
      failure.observe(this@AddRecordFragment,
        Observer {
          clAddRecord.showSnackbar(it)
        })
    }

    llAddRecordCategory.setOnClickListener {
      findNavController().navigate(AddRecordFragmentDirections.nextFragment())
    }
    tvAddRecordLLCategory.text = "None"
  }

}
