package com.dkgtech.coffeehouse.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dkgtech.coffeehouse.R
import com.dkgtech.coffeehouse.adapter.RecyclerCoffeeCategoryAdapter
import com.dkgtech.coffeehouse.databinding.FragmentHomeBinding
import com.dkgtech.coffeehouse.model.CoffeeCategoryModel
import com.google.firebase.firestore.ktx.firestore
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
            val coffeeCategoryModel = ArrayList<CoffeeCategoryModel>()
            db.collection("coffeeCategories").get().addOnSuccessListener {
                for (doc in it.documents) {
                    coffeeCategoryModel.add(doc.toObject(CoffeeCategoryModel::class.java)!!)
                    Log.d("TAG", "${it.documents}")
                }
                rcViewCategories.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                rcViewCategories.adapter =
                    RecyclerCoffeeCategoryAdapter(requireContext(), coffeeCategoryModel)
            }

        }



        return binding.root
    }
}