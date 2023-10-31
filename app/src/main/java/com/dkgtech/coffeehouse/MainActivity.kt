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
            bnView.setOnItemSelectedListener {
                when (it) {
                    0 -> {
                        loadFragment(HomeFragment(), false)

                    }
                    1 -> {
                        loadFragment(CartFragment(), false)
                    }
                    2 -> {
                        loadFragment(FavouriteFragment(), false)
                    }
                    else -> {
                        loadFragment(NotificationFragment(), false)
                    }
                }
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
        ft.attach(frag)
        ft.commit()

    }
}