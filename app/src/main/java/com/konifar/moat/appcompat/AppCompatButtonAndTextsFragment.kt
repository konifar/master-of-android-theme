package com.konifar.moat.appcompat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.konifar.moat.R
import com.konifar.moat.databinding.AppcompatButtonsAndTextsFragmentBinding

class AppCompatButtonAndTextsFragment : Fragment() {

    companion object {
        fun newInstance() = AppCompatButtonAndTextsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: AppcompatButtonsAndTextsFragmentBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.appcompat_buttons_and_texts_fragment, container, false)
        return binding.root
    }

}
