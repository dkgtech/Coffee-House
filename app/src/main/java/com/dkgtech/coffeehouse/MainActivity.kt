package com.dkgtech.coffeehouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.dkgtech.coffeehouse.databinding.ActivityMainBinding
import com.dkgtech.coffeehouse.ui.CartFragment
import com.dkgtech.coffeehouse.ui.FavouriteFragment
import com.dkgtech.coffeehouse.ui.HomeFragment
import com.dkgtech.coffeehouse.ui.NotificationFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fm: FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            fm = supportFragmentManager

            loadFragment(HomeFragment(), true)
            bnView.selectedItemId = R.id.menu_home

            bnView.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_home -> loadFragment(HomeFragment(), false)
                    R.id.menu_cart -> loadFragment(CartFragment(), false)
                    R.id.menu_favourite -> loadFragment(FavouriteFragment(), false)
                    R.id.menu_notification -> loadFragment(NotificationFragment(), false)

                }
                true
            }

        }
    }

    private fun loadFragment(frag: Fragment, flag: Boolean) {
        val ft = fm.beginTransaction()
        if (flag) {
            ft.add(R.id.container, frag)
        } else {
            ft.replace(R.id.container, frag)
        }
        ft.commit()
    }
}