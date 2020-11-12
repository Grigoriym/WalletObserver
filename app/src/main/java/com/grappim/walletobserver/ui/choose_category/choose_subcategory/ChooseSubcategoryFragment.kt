package com.grappim.walletobserver.ui.choose_category.choose_subcategory

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.grappim.walletobserver.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_choose_subcategory.recyclerSubCategories
import timber.log.Timber

@AndroidEntryPoint
class ChooseSubcategoryFragment : Fragment(R.layout.fragment_choose_subcategory) {

    private val cAdapter: ChooseSubCategoryAdapter by lazy {
        ChooseSubCategoryAdapter {

        }
    }
    private val viewModel: ChooseSubcategoryViewModel by viewModels()
    private val args: ChooseSubcategoryFragmentArgs by navArgs()

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
                viewLifecycleOwner, {
                    cAdapter.loadItems(it)
                }
            )
            loadSubcategories(args.categoryId)
        }
    }

    private fun initRecycler() {
        recyclerSubCategories.apply {
            adapter = cAdapter
        }
    }
}
