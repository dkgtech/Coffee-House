package com.dkgtech.coffeehouse.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dkgtech.coffeehouse.CoffeeDetailActivity
import com.dkgtech.coffeehouse.databinding.CoffeesRowBinding
import com.dkgtech.coffeehouse.model.CoffeeCategoryModel
import com.squareup.picasso.Picasso

class RecyclerCoffeeAdapter(val context: Context, val coffeelist: ArrayList<CoffeeCategoryModel>) :
    RecyclerView.Adapter<RecyclerCoffeeAdapter.ViewHolder>() {
    class ViewHolder(val binding: CoffeesRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CoffeesRowBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return coffeelist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            Picasso.get().load(coffeelist[position].catImage).into(imgCoffee)
            txtCoffeeTitle.text = coffeelist[position].catTitle
            txtCoffeeSubTitle.text = coffeelist[position].catSubTitle
            txtCoffeePrice.text = coffeelist[position].catPrice
            coffeeRow.setOnClickListener {
                context.startActivity(
                    Intent(
                        context,
                        CoffeeDetailActivity::class.java
                    ).putExtra("catId", coffeelist[position].catId)
                )
            }
        }
    }
}