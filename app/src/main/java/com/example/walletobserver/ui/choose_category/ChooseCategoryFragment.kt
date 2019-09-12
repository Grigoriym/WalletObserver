package com.example.walletobserver.ui.choose_category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.walletobserver.R
import kotlinx.android.synthetic.main.fragment_choose_category.*
import org.koin.core.KoinComponent
import org.koin.core.inject
import timber.log.Timber

class ChooseCategoryFragment : Fragment(), KoinComponent {

  private lateinit var cAdapter: ChooseCategoryAdapter
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
    initRecycler()
    initViewModel()
  }

  private fun initViewModel() {
    viewModel.apply {
      getAllCategories().observe(this@ChooseCategoryFragment, Observer {
        it?.let {
          cAdapter.loadItems(it)
        }
      })
      loadCategories()
    }
  }

  private fun initRecycler() {
    cAdapter = ChooseCategoryAdapter {
      findNavController().navigate(ChooseCategoryFragmentDirections.nextFragment(it.id))
    }
    recyclerCategories.apply {
      layoutManager = LinearLayoutManager(context)
      adapter = cAdapter
    }
  }

}
