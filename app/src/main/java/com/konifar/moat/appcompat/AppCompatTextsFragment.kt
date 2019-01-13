package com.konifar.moat.appcompat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.konifar.moat.R
import com.konifar.moat.databinding.AppcompatTextsFragmentBinding

class AppCompatTextsFragment : Fragment() {

    companion object {
        fun newInstance() = AppCompatTextsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: AppcompatTextsFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.appcompat_texts_fragment, container, false)

        binding.textInputLayoutError.error = "Error"
        return binding.root
    }
}
