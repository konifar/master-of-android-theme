package com.konifar.moat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.konifar.moat.databinding.AppcompatExamplesFragmentBinding
import kotlinx.android.synthetic.main.layout_appcompat_forms.view.*

class AppCompatExamplesFragment : Fragment() {

    companion object {
        fun newInstance() = AppCompatExamplesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: AppcompatExamplesFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.appcompat_examples_fragment, container, false)

        binding.forms.text_input_layout_error.error = "Error message"

        return binding.root
    }
}
