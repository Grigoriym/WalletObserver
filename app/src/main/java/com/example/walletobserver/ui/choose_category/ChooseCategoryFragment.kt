package com.example.walletobserver.ui.choose_category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.walletobserver.R
import org.koin.core.KoinComponent
import org.koin.core.inject
import timber.log.Timber

class ChooseCategoryFragment : Fragment(), KoinComponent {

  private val viewModelFactory: ChooseCategoryViewModelFactory by inject()
  private val viewModel by viewModels<ChooseCategoryViewModel> { viewModelFactory }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? =
    inflater.inflate(R.layout.fragment_choose_category, container, false)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    Timber.d("ChooseCategoryFragment - onViewCreated")

    viewModelInit()
  }

  private fun viewModelInit() {
    viewModel.apply {
      getAllCategories().observe(this@ChooseCategoryFragment, Observer {
        it?.let {
          println("11111 - ${it.size}")
        }
      })
    }
    viewModel.loadCategories()
  }

}
