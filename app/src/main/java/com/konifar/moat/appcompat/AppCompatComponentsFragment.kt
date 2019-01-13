package com.konifar.moat.appcompat

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.konifar.moat.R
import com.konifar.moat.databinding.AppcompatComponentsFragmentBinding

class AppCompatComponentsFragment : Fragment() {

    companion object {
        fun newInstance() = AppCompatComponentsFragment()
    }

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: AppcompatComponentsFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.appcompat_components_fragment, container, false)

        binding.alertDialog.setOnClickListener {
            context?.let { cxt ->
                AlertDialog.Builder(cxt)
                    .setTitle("Title")
                    .setMessage("Message")
                    .setPositiveButton("Positive") { _: DialogInterface, _: Int -> }
                    .setNegativeButton("Negative") { _: DialogInterface, _: Int -> }
                    .create()
                    .show()
            }
        }

        bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheetView)
        binding.bottomSheet.setOnClickListener {
            context?.let {
                if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
                } else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
                }
            }
        }

        return binding.root
    }
}
