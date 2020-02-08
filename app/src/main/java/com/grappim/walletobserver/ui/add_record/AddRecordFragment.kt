package com.grappim.walletobserver.ui.add_record

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.grappim.walletobserver.R
import kotlinx.android.synthetic.main.fragment_add_record_new.*
import org.koin.core.KoinComponent
import timber.log.Timber

class AddRecordFragment : Fragment(), KoinComponent {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? =
    inflater.inflate(R.layout.fragment_add_record_new, container, false)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    Timber.d("AddRecordFragment - onViewCreated")
    initViews()
  }

  private fun initViews() {
    llAddRecordCategory.setOnClickListener {
      findNavController().navigate(AddRecordFragmentDirections.nextFragment())
    }
    tvAddRecordLLCategory.text = getString(R.string.title_none)
  }

}
