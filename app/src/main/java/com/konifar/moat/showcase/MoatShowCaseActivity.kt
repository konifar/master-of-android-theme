package com.konifar.moat.showcase

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import com.konifar.moat.*
import com.konifar.moat.databinding.MoatShowCaseActivityBinding

/**
 * Cat colorful
 */
class MoatShowCaseActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context) = Intent(context, MoatShowCaseActivity::class.java)
    }

    private lateinit var binding: MoatShowCaseActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set before setContentView()
        setTheme(R.style.MoatVividCaseStudyTheme)
        setUpTheme()
        binding = DataBindingUtil.setContentView(this, R.layout.moat_show_case_activity)
        setSupportActionBar(binding.toolbar)
        setUpTabs()

        binding.fab.setOnClickListener {
            SettingsDialogFragment.newInstance()
                .show(supportFragmentManager, MoatShowCaseActivity::class.java.simpleName)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.show_case_menu, menu)
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
            R.id.toggle_theme -> {
                toggleTheme()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun setUpTheme() {
        val config = ThemeConfigManager.getCurrentConfig(this)
        setTheme(config.showCaseThemeResId)
        CommonHelper.changeDarkMode(this, config.darkMode)
    }

    private fun toggleTheme() {
        val currentConfig = ThemeConfigManager.getCurrentConfig(this)
        val newThemeResId =
            if (currentConfig.showCaseThemeResId == R.style.MoatVividCaseStudyTheme) R.style.MoatSimpleCaseStudyTheme else R.style.MoatVividCaseStudyTheme
        val newConfig = ThemeConfig.CAT_COLORFUL.apply {
            darkMode = currentConfig.darkMode
            showCaseThemeResId = newThemeResId
        }
        ThemeConfigManager.saveConfig(this, newConfig)

        Handler().postDelayed({
            finish()
            startActivity(Intent(this, MoatShowCaseActivity::class.java))
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }, 200)

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
            Tab.Components()
        )

        sealed class Tab(@StringRes val titleResId: Int) {
            abstract val fragment: Fragment

            class ButtonsAndTexts : Tab(R.string.texts_title) {
                override val fragment = ShowCaseButtonAndTextsFragment.newInstance()
            }

            class Components : Tab(R.string.components_title) {
                override val fragment = ShowCaseComponentsFragment.newInstance()
            }
        }

        override fun getItem(position: Int): Fragment = tabs[position].fragment

        override fun getPageTitle(position: Int): CharSequence? =
            activity.getString(tabs[position].titleResId)

        override fun getCount(): Int = tabs.count()

    }
}
