package com.konifar.moat

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.konifar.moat.appcompat.MoatAppCompatActivity
import com.konifar.moat.databinding.SettingsDialogFragmentBinding
import com.konifar.moat.materialcomponents.MoatMaterialComponentsActivity
import com.konifar.moat.showcase.MoatShowCaseActivity

class SettingsDialogFragment : DialogFragment() {

    companion object {
        fun newInstance() = SettingsDialogFragment()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = LayoutInflater.from(context)
        val binding: SettingsDialogFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.settings_dialog_fragment, null, false)

        setUp(binding)

        return AlertDialog.Builder(context!!)
            .setView(binding.root)
            .create()
    }

    private fun setUp(binding: SettingsDialogFragmentBinding) {
        if (context == null) return

        val config = ThemeConfigManager.getCurrentConfig(context!!)
        binding.darkMode.isChecked = config.darkMode
        binding.darkMode.setOnCheckedChangeListener { _, isChecked ->
            val c = ThemeConfigManager.getCurrentConfig(context!!)
            c.darkMode = isChecked
            ThemeConfigManager.saveConfig(context!!, c)
            CommonHelper.changeDarkMode(activity as AppCompatActivity, c.darkMode)
        }

        binding.appcompat.setOnClickListener {
            showActivity(MoatAppCompatActivity.createIntent(context!!))
        }

        binding.materialComponent.setOnClickListener {
            showActivity(MoatMaterialComponentsActivity.createIntent(context!!))
        }

        binding.showCase.setOnClickListener {
            showActivity(MoatShowCaseActivity.createIntent(context!!))
        }
    }

    private fun showActivity(intent: Intent) {
        startActivity(intent)
        activity?.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        activity?.finish()
    }

}