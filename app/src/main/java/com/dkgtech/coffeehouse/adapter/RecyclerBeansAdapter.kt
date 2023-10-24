package com.dkgtech.coffeehouse.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dkgtech.coffeehouse.databinding.BeansRowBinding
import com.dkgtech.coffeehouse.model.CoffeeBeansModel
import com.squareup.picasso.Picasso

class RecyclerBeansAdapter(val context: Context, val beansList: ArrayList<CoffeeBeansModel>) :
    RecyclerView.Adapter<RecyclerBeansAdapter.ViewHolder>() {
    class ViewHolder(val binding: BeansRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(BeansRowBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return beansList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding){
            Picasso.get().load(beansList[position].catImage).into(imgBeans)
            txtBeansTitle.text = beansList[position].catTitle
        }
    }
}