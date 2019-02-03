package com.konifar.moat.showcase

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import com.konifar.moat.CommonHelper
import com.konifar.moat.R
import com.konifar.moat.ThemeConfigManager
import com.konifar.moat.databinding.MoatShowCaseActivityBinding

/**
 * Cat one
 */
class MoatShowCaseActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context) = Intent(context, MoatShowCaseActivity::class.java)
    }

    private lateinit var binding: MoatShowCaseActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpTheme()
        binding = DataBindingUtil.setContentView(this, R.layout.moat_show_case_activity)
        setSupportActionBar(binding.toolbar)
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

}
