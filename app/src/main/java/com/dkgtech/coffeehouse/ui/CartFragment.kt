package com.dkgtech.coffeehouse.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dkgtech.coffeehouse.R
import com.dkgtech.coffeehouse.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    lateinit var binding: FragmentCartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater, container, false)
        with(binding) {


        }
        return binding.root
    }
}