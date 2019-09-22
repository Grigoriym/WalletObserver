package com.grappim.walletobserver.ui.choose_category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.grappim.walletobserver.R
import com.grappim.walletobserver.db.entities.CategoryEntity
import kotlinx.android.synthetic.main.item_category.view.*

class ChooseCategoryAdapter(
  val onClick: (CategoryEntity) -> Unit
) : RecyclerView.Adapter<ChooseCategoryViewHolder>() {

  private var items = listOf<CategoryEntity>()

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): ChooseCategoryViewHolder =
    ChooseCategoryViewHolder(
      LayoutInflater.from(parent.context)
        .inflate(R.layout.item_category, parent, false)
    )

  override fun getItemCount(): Int = items.size

  override fun onBindViewHolder(
    holder: ChooseCategoryViewHolder,
    position: Int
  ) {
    holder.apply {
      category = items[position]
      itemView.setOnClickListener {
        onClick(items[position])
      }
    }
  }

  fun loadItems(newItems:List<CategoryEntity>){
    items = newItems
    notifyDataSetChanged()
  }

}

class ChooseCategoryViewHolder(
  private val view: View
) : RecyclerView.ViewHolder(view) {
  var category: CategoryEntity? = null
    set(value) {
      field = value
      view.apply {
        textName.text = value?.name
      }
    }
}