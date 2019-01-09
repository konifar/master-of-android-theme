package com.konifar.moat.appcompat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.konifar.moat.R
import com.konifar.moat.databinding.AppcompatButtonsFragmentBinding

class AppCompatButtonsFragment : Fragment() {

    companion object {
        fun newInstance() = AppCompatButtonsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: AppcompatButtonsFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.appcompat_buttons_fragment, container, false)
        return binding.root
    }
}
