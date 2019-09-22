package com.grappim.walletobserver.ui.choose_category.choose_subcategory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.grappim.walletobserver.R
import kotlinx.android.synthetic.main.fragment_choose_subcategory.*
import org.koin.android.ext.android.inject
import timber.log.Timber

class ChooseSubcategoryFragment : Fragment() {

  private lateinit var cAdapter: ChooseSubCategoryAdapter
  private val viewModelFactory: ChooseSubcategoryViewModelFactory by inject()
  private val viewModel by viewModels<ChooseSubcategoryViewModel> { viewModelFactory }
  private val args: ChooseSubcategoryFragmentArgs by navArgs()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? =
    inflater.inflate(R.layout.fragment_choose_subcategory, container, false)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    Timber.d("ChooseSubcategoryFragment - onViewCreated")
    initRecycler()
    initViewModel()
  }

  private fun initViewModel() {
    viewModel.apply {
      currentCategoryID = args.categoryId

      getSubCategoriesByCategoryId(args.categoryId).observe(
        this@ChooseSubcategoryFragment,
        Observer {
          cAdapter.loadItems(it)
        }
      )
      loadSubcategories(args.categoryId)
    }
  }

  private fun initRecycler() {
    cAdapter = ChooseSubCategoryAdapter {

    }
    recyclerSubCategories.apply {
      layoutManager = LinearLayoutManager(context)
      adapter = cAdapter
    }
  }
}
