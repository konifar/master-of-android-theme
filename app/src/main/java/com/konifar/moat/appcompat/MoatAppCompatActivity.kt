package com.konifar.moat.appcompat

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import com.konifar.moat.CommonHelper
import com.konifar.moat.R
import com.konifar.moat.SettingsDialogFragment
import com.konifar.moat.ThemeConfigManager
import com.konifar.moat.databinding.MoatAppcompatActivityBinding

/**
 * Cat one
 */
class MoatAppCompatActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context) = Intent(context, MoatAppCompatActivity::class.java)
    }

    private lateinit var binding: MoatAppcompatActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpTheme()
        binding = DataBindingUtil.setContentView(this, R.layout.moat_appcompat_activity)
        setSupportActionBar(binding.toolbar)
        setUpTabs()

        binding.fab.setOnClickListener {
            SettingsDialogFragment.newInstance().show(supportFragmentManager, MoatAppCompatActivity::class.java.simpleName)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.menu_github -> {
                CommonHelper.showGitHubRepository(this)
                true
            }
            R.id.menu_oss -> {
                OssLicensesMenuActivity.setActivityTitle(getString(R.string.oss_license_title))
                startActivity(Intent(this, OssLicensesMenuActivity::class.java))
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun setUpTheme() {
        val config = ThemeConfigManager.getCurrentConfig(this)
        CommonHelper.changeDarkMode(this, config.darkMode)
    }

    private fun setUpTabs() {
        binding.viewPager.adapter = PagerAdapter(this)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

    data class PagerAdapter(
        val activity: AppCompatActivity
    ) : FragmentStatePagerAdapter(activity.supportFragmentManager) {

        private val tabs = arrayListOf(
            Tab.ButtonsAndTexts(),
            Tab.Components(),
            Tab.Colors()
        )

        sealed class Tab(@StringRes val titleResId: Int) {
            abstract val fragment: Fragment

            class ButtonsAndTexts : Tab(R.string.texts_title) {
                override val fragment = AppCompatButtonAndTextsFragment.newInstance()
            }

            class Components : Tab(R.string.components_title) {
                override val fragment = AppCompatComponentsFragment.newInstance()
            }

            class Colors : Tab(R.string.colors_title) {
                override val fragment = AppCompatColorsFragment.newInstance()
            }
        }

        override fun getItem(position: Int): Fragment = tabs[position].fragment

        override fun getPageTitle(position: Int): CharSequence? =
            activity.getString(tabs[position].titleResId)

        override fun getCount(): Int = tabs.count()
    }

}
