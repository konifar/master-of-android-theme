package com.konifar.moat.appcompat

import android.app.AlertDialog
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.konifar.moat.R
import com.konifar.moat.databinding.AppcompatComponentsFragmentBinding
import kotlinx.android.synthetic.main.layout_appcompat_actions.view.*

class AppCompatComponentsFragment : Fragment() {

    companion object {
        fun newInstance() = AppCompatComponentsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: AppcompatComponentsFragmentBinding = DataBindingUtil.inflate(layoutInflater, R.layout.appcompat_components_fragment, container, false)
        setUpActions(binding)
        return binding.root
    }

    private fun setUpActions(binding: AppcompatComponentsFragmentBinding) {
        binding.actions.alert_dialog.setOnClickListener {
            AlertDialog.Builder(context)
                .setTitle("Title")
                .setMessage("Message")
                .setPositiveButton("OK") { _, _ -> }
                .setNegativeButton("Cancel") { _, _ -> }
                .create()
                .show()
        }
        binding.actions.toast.setOnClickListener {
            Toast.makeText(context, "Toast", Toast.LENGTH_SHORT).apply {
                setGravity(Gravity.CENTER, 0, 0)
            }.show()
        }
        binding.actions.popup_menu.setOnClickListener {
            PopupMenu(context!!, it).apply {
                menuInflater.inflate(R.menu.popup_menu, this.menu)
            }.show()
        }
    }
}
