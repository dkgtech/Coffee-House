package com.dkgtech.coffeehouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.dkgtech.coffeehouse.databinding.ActivityCoffeeDetailBinding
import com.dkgtech.coffeehouse.databinding.FragmentCartBinding
import com.dkgtech.coffeehouse.model.CoffeeCategoryModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso

class CoffeeDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityCoffeeDetailBinding
    lateinit var coffeeCategoryModel: CoffeeCategoryModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoffeeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {

            val db = Firebase.firestore
            val catId = intent.getStringExtra("catId")
            db.collection("coffeeCategories")
                .whereEqualTo("catId", catId).get().addOnSuccessListener {
                    if (it.size() == 1) {
                        coffeeCategoryModel =
                            it.documents[0].toObject(CoffeeCategoryModel::class.java)!!
                        Picasso.get().load(coffeeCategoryModel.catImage).into(imageView)
                        txtTitle.text = coffeeCategoryModel.catTitle
                        txtSubTitle.text = coffeeCategoryModel.catSubTitle
                        txtDescription.text = coffeeCategoryModel.catDescription
                        txtPrice.text = coffeeCategoryModel.catPrice
                    }
                }


            imgBack.setOnClickListener {
                startActivity(Intent(this@CoffeeDetailActivity, MainActivity::class.java))
            }

            btnAddToCart.setOnClickListener {
                var cartMap = mapOf<String, Any>(
                    "catId" to coffeeCategoryModel.catId,
                    "catImage" to coffeeCategoryModel.catImage,
                    "catTitle" to coffeeCategoryModel.catTitle,
                    "catSubTitle" to coffeeCategoryModel.catSubTitle,
                    "catPrice" to coffeeCategoryModel.catPrice
                )

                db
                    .collection("users")
                    .document("5LjCmU5tQJhrtotgKypw")
                    .collection("myCart")
                    .add(cartMap).addOnSuccessListener {
                        successful.visibility = View.VISIBLE
                    }
            }

        }
    }
}