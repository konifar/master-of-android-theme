package com.konifar.moat.materialcomponents

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
import com.konifar.moat.databinding.MaterialComponentsComponentsFragmentBinding
import kotlinx.android.synthetic.main.layout_appcompat_actions.view.*

class MaterialComponentsComponentsFragment : Fragment() {

    companion object {
        fun newInstance() = MaterialComponentsComponentsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: MaterialComponentsComponentsFragmentBinding = DataBindingUtil.inflate(layoutInflater, R.layout.material_components_components_fragment, container, false)
        setUpActions(binding)
        return binding.root
    }

    private fun setUpActions(binding: MaterialComponentsComponentsFragmentBinding) {
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
