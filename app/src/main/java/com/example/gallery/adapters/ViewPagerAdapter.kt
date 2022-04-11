package com.example.gallery.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.gallery.ui.fragments.*

class ViewPagerAdapter(supportFragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(supportFragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        val fragment: Fragment = when (position) {
            0 -> All.newInstance()
            1 -> Nature.newInstance()
            2 -> Animals.newInstance()
            3 -> New.newInstance()
            else -> Technology.newInstance()

        }

        return fragment
    }
}