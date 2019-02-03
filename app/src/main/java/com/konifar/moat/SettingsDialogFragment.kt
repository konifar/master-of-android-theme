package com.konifar.moat

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.konifar.moat.appcompat.CatGreyActivity
import com.konifar.moat.databinding.SettingsDialogFragmentBinding
import com.konifar.moat.materialcomponents.CatBrownActivity

class SettingsDialogFragment : DialogFragment() {

    companion object {
        fun newInstance() = SettingsDialogFragment()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = LayoutInflater.from(context)
        val binding: SettingsDialogFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.settings_dialog_fragment, null, false)

        setUp(binding)

        return AlertDialog.Builder(context!!)
            .setView(binding.root)
            .create()
    }

    private fun setUp(binding: SettingsDialogFragmentBinding) {
        binding.appcompat.setOnClickListener {
            val intent = CatGreyActivity.createIntent(context!!)
            startActivity(intent)
            activity?.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            activity?.finish()
        }

        binding.materialComponent.setOnClickListener {
            val intent = CatBrownActivity.createIntent(context!!)
            startActivity(intent)
            activity?.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            activity?.finish()
        }
    }

}