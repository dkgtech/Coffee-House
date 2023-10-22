package com.dkgtech.coffeehouse.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dkgtech.coffeehouse.databinding.CoffeeCategoryRowBinding
import com.dkgtech.coffeehouse.model.CoffeeCategoryModel

class RecyclerCoffeeCategoryAdapter(
    val context: Context,
    val categoryList: ArrayList<CoffeeCategoryModel>
) :
    RecyclerView.Adapter<RecyclerCoffeeCategoryAdapter.ViewHolder>() {
    class ViewHolder(val binding: CoffeeCategoryRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CoffeeCategoryRowBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            txtCatTitle.text = categoryList[position].catTitle
        }
    }
}