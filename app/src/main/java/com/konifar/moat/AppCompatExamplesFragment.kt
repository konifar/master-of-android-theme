package com.konifar.moat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.konifar.moat.databinding.AppcompatExamplesFragmentBinding

class AppCompatExamplesFragment : Fragment() {

    companion object {
        fun newInstance() = AppCompatExamplesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: AppcompatExamplesFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.appcompat_examples_fragment, container, false)
        return binding.root
    }
}
