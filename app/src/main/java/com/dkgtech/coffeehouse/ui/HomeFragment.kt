package com.dkgtech.coffeehouse.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dkgtech.coffeehouse.R
import com.dkgtech.coffeehouse.adapter.RecyclerBeansAdapter
import com.dkgtech.coffeehouse.adapter.RecyclerCoffeeAdapter
import com.dkgtech.coffeehouse.adapter.RecyclerCoffeeCategoryAdapter
import com.dkgtech.coffeehouse.databinding.FragmentHomeBinding
import com.dkgtech.coffeehouse.model.CoffeeBeansModel
import com.dkgtech.coffeehouse.model.CoffeeCategoryModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val db = Firebase.firestore
        with(binding) {

//            for categories

            val coffeeCategoryModel = ArrayList<CoffeeCategoryModel>()
            db.collection("coffeeCategories").get().addOnSuccessListener {
                for (doc in it.documents) {
                    coffeeCategoryModel.add(doc.toObject(CoffeeCategoryModel::class.java)!!)
                }
                rcViewCategories.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                rcViewCategories.adapter =
                    RecyclerCoffeeCategoryAdapter(requireContext(), coffeeCategoryModel)
            }


//            for coffees

            db.collection("coffeeCategories").get().addOnSuccessListener {
                for (doc in it.documents) {
                    coffeeCategoryModel.add(doc.toObject(CoffeeCategoryModel::class.java)!!)
                }
                rcViewCoffees.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                rcViewCoffees.adapter =
                    RecyclerCoffeeAdapter(requireContext(), coffeeCategoryModel)
            }


//            for coffee beans

            val beansModel = ArrayList<CoffeeBeansModel>()
            db.collection("coffeeBeansCategories").get().addOnSuccessListener {
                for (doc in it.documents) {
                    beansModel.add(doc.toObject(CoffeeBeansModel::class.java)!!)
                }
                binding.rcViewCoffeeBeans.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                binding.rcViewCoffeeBeans.adapter =
                    RecyclerBeansAdapter(requireContext(), beansModel)
            }
        }



        return binding.root
    }
}