package com.grappim.walletobserver.ui.choose_category

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.grappim.walletobserver.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_choose_category.recyclerCategories
import timber.log.Timber

@AndroidEntryPoint
class ChooseCategoryFragment : Fragment(R.layout.fragment_choose_category) {

    private val cAdapter: ChooseCategoryAdapter by lazy {
        ChooseCategoryAdapter {
            findNavController().navigate(ChooseCategoryFragmentDirections.nextFragment(it.id))
        }
    }

    private val viewModel: ChooseCategoryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("ChooseCategoryFragment - onViewCreated")
        initRecycler()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.apply {
            getAllCategories().observe(viewLifecycleOwner, {
                it?.let {
                    cAdapter.loadItems(it)
                }
            })
            loadCategories()
        }
    }

    private fun initRecycler() {
        recyclerCategories.apply {
            adapter = cAdapter
        }
    }

}
