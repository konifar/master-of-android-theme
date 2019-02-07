package com.konifar.moat.appcompat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.konifar.moat.R
import com.konifar.moat.databinding.AppcompatColorsFragmentBinding

class AppCompatColorsFragment : Fragment() {

    companion object {
        fun newInstance() = AppCompatColorsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: AppcompatColorsFragmentBinding = DataBindingUtil.inflate(layoutInflater, R.layout.appcompat_colors_fragment, container, false)
        return binding.root
    }

}
