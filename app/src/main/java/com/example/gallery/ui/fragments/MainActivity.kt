package com.example.gallery.ui.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.gallery.R
import com.example.gallery.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var pager2: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

        pager2.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout, pager2) { tab, position ->

            when (position) {
                0 -> {

                    tab.text = "All"
                }
                1 -> {
                    tab.text = "Nature"
                }
                2 -> {
                    tab.text = "Animals"
                }
                3 -> {
                    tab.text = "New"
                }
                else -> {
                    tab.text = "Technology"
                }
            }

        }.attach()


    }

    private fun initView() {
        pager2 = findViewById(R.id.viewpager2)
        tabLayout = findViewById(R.id.tab_layout)

    }
}
//tab.setIcon(R.drawable.ic_point)
//tab.setIcon(R.drawable.ic_point)
//tab.setIcon(R.drawable.ic_point)
//tab.setIcon(R.drawable.ic_point)
//tab.setIcon(R.drawable.ic_point)