package com.konifar.moat.appcompat

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.konifar.moat.R
import com.konifar.moat.databinding.MoatAppcompatActivityBinding

class MoatAppCompatActivity : AppCompatActivity() {

    private lateinit var binding: MoatAppcompatActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.moat_appcompat_activity)
        actionBar?.apply {
            title = getString(R.string.appcompat_title)
        }

        setUpTabs()
    }

    private fun setUpTabs() {
        binding.viewPager.adapter = PagerAdapter(this)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

    data class PagerAdapter(
        val activity: AppCompatActivity
    ) : FragmentStatePagerAdapter(activity.supportFragmentManager) {

        private val tabs = arrayListOf(
            Tab.Buttons(),
            Tab.Buttons(),
            Tab.Buttons(),
            Tab.Buttons(),
            Tab.Buttons(),
            Tab.Buttons(),
            Tab.Buttons(),
            Tab.Buttons(),
            Tab.Buttons(),
            Tab.Buttons()
        )

        sealed class Tab(@StringRes val titleResId: Int) {
            abstract val fragment: Fragment

            class Buttons : Tab(R.string.appcompat_buttons) {
                override val fragment = AppCompatButtonsFragment.newInstance()
            }
        }

        override fun getItem(position: Int): Fragment = tabs[position].fragment

        override fun getPageTitle(position: Int): CharSequence? =
            activity.getString(tabs[position].titleResId)

        override fun getCount(): Int = tabs.count()
    }
}
