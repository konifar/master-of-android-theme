package com.konifar.moat

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.browser.customtabs.CustomTabsIntent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.konifar.moat.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val PREF_KEY_CONFIG = "pref_key_config"
        const val REPOSITORY_URL = "https://github.com/konifar/master-of-android-theme"
    }

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpTheme()

        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        actionBar?.apply {
            title = getString(R.string.app_name)
        }

        setUpTabs()

        setUpThemeIcons()

        setUpDarkMode()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.menu_github -> {
                showBrowser(REPOSITORY_URL)
                true
            }
            R.id.menu_oss -> {
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun showBrowser(url: String) {
        CustomTabsIntent.Builder()
            .setShowTitle(true)
            .build()
            .launchUrl(this, Uri.parse(url))
    }

    private fun setUpTheme() {
        val config = ThemeConfigManager.getCurrentConfig(this)
        setTheme(config.appCompatThemeResId)
    }

    private fun setUpThemeIcons() {
        clearThemeIcons()
        val config = ThemeConfigManager.getCurrentConfig(this)
        binding.themeIcons.getChildAt(config.index).isSelected = true

        val count = binding.themeIcons.childCount
        for (i in 0 until count) {
            val view = binding.themeIcons.getChildAt(i)
            view.setOnClickListener {
                clearThemeIcons()
                it.isSelected = true
                ThemeConfigManager.saveConfig(this, ThemeConfig.from(i))
                restart()
            }
        }
    }

    private fun setUpDarkMode() {
        val config = ThemeConfigManager.getCurrentConfig(this)
        binding.darkMode.isSelected = config.darkMode
        changeDarkMode(config.darkMode)

        binding.darkMode.setOnCheckedChangeListener { _, isChecked ->
            val c = ThemeConfigManager.getCurrentConfig(this)
            c.darkMode = isChecked
            ThemeConfigManager.saveConfig(this, c)
            changeDarkMode(c.darkMode)
        }
    }

    private fun changeDarkMode(darkMode: Boolean) {
        Handler().postDelayed({
            if (darkMode) {
                delegate.setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                delegate.setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }, 200)
    }

    private fun restart() {
        Handler().postDelayed({
            finish()
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }, 200)
    }

    private fun clearThemeIcons() {
        val count = binding.themeIcons.childCount
        for (i in 0 until count) {
            binding.themeIcons.getChildAt(i).isSelected = false
        }
    }

    private fun setUpTabs() {
        binding.viewPager.adapter = PagerAdapter(this)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

    data class PagerAdapter(
        val activity: AppCompatActivity
    ) : FragmentStatePagerAdapter(activity.supportFragmentManager) {

        private val tabs = arrayListOf(
            Tab.AppCompat(),
            Tab.MaterialComponents()
        )

        sealed class Tab(@StringRes val titleResId: Int) {
            abstract val fragment: Fragment

            class AppCompat : Tab(R.string.appcompat_title) {
                override val fragment = AppCompatExamplesFragment.newInstance()
            }

            class MaterialComponents : Tab(R.string.material_components_title) {
                override val fragment = MaterialComponentsExamplesFragment.newInstance()
            }
        }

        override fun getItem(position: Int): Fragment = tabs[position].fragment

        override fun getPageTitle(position: Int): CharSequence? =
            activity.getString(tabs[position].titleResId)

        override fun getCount(): Int = tabs.count()
    }

}
