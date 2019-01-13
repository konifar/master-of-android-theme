package com.konifar.moat

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.konifar.moat.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val PREF_KEY_CONFIG = "pref_key_config"
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

    private fun setUpTheme() {
        val config = getCurrentConfig()
        setTheme(config.themeResId)
    }

    @SuppressLint("ApplySharedPref")
    private fun saveConfig(config: Config) {
        val pref = getSharedPreferences("default", Context.MODE_PRIVATE)
        pref.edit().putString(PREF_KEY_CONFIG, config.toString()).commit()
    }

    private fun getCurrentConfig(): Config {
        val pref = getSharedPreferences("default", Context.MODE_PRIVATE)
        val configString = pref.getString(PREF_KEY_CONFIG, Config.CAT_ONE.toString())
        return if (configString != null) {
            Config.valueOf(configString)
        } else {
            Config.CAT_ONE
        }
    }

    private fun setUpThemeIcons() {
        clearTheme()
        val config = getCurrentConfig()
        binding.themeIcons.getChildAt(config.index).isSelected = true

        val count = binding.themeIcons.childCount
        for (i in 0 until count) {
            val view = binding.themeIcons.getChildAt(i)
            view.setOnClickListener {
                clearTheme()
                it.isSelected = true
                saveConfig(Config.from(i))
                restart()
            }
        }
    }

    private fun setUpDarkMode() {
        val config = getCurrentConfig()
        binding.darkMode.isSelected = config.darkMode
        changeDarkMode(config.darkMode)

        binding.darkMode.setOnCheckedChangeListener { _, isChecked ->
            val c = getCurrentConfig()
            c.darkMode = isChecked
            saveConfig(c)
            changeDarkMode(c.darkMode)
        }
    }

    private fun changeDarkMode(darkMode: Boolean) {
        if (darkMode) {
            delegate.setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            delegate.setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun restart() {
        Handler().postDelayed({
            finish()
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }, 300)
    }

    private fun clearTheme() {
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

    enum class Config(
        val index: Int,
        val themeResId: Int,
        var darkMode: Boolean
    ) {

        CAT_ONE(0, R.style.AppTheme, false),
        CAT_TWO(1, R.style.AppTheme_CatTwo, false),
        CAT_COLORFUL(2, R.style.AppTheme_AppCompat_Vivid, false);

        companion object {
            fun from(index: Int): Config {
                return when (index) {
                    0 -> CAT_ONE
                    1 -> CAT_TWO
                    2 -> CAT_COLORFUL
                    else -> throw IllegalArgumentException("$index is not supported.")
                }
            }
        }
    }
}
