package com.grappim.walletobserver.ui.choose_category.choose_subcategory

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.grappim.walletobserver.R
import com.grappim.walletobserver.core.db.entities.SubCategoryEntity
import com.grappim.walletobserver.core.extensions.inflate
import kotlinx.android.synthetic.main.item_category.view.textName

class ChooseSubCategoryAdapter(
    val onClick: (SubCategoryEntity) -> Unit
) : RecyclerView.Adapter<ChooseCategoryViewHolder>() {

    private var items = listOf<SubCategoryEntity>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChooseCategoryViewHolder =
        ChooseCategoryViewHolder(parent.inflate(R.layout.item_category))

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

    fun loadItems(newItems: List<SubCategoryEntity>) {
        items = newItems
        notifyDataSetChanged()
    }

}

class ChooseCategoryViewHolder(
    private val view: View
) : RecyclerView.ViewHolder(view) {
    var category: SubCategoryEntity? = null
        set(value) {
            field = value
            view.apply {
                textName.text = value?.name
            }
        }
}