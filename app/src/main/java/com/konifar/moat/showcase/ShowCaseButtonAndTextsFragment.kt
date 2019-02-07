package com.konifar.moat.showcase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.konifar.moat.R
import com.konifar.moat.databinding.ShowCaseButtonsAndTextsFragmentBinding

class ShowCaseButtonAndTextsFragment : Fragment() {

    companion object {
        fun newInstance() = ShowCaseButtonAndTextsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ShowCaseButtonsAndTextsFragmentBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.show_case_buttons_and_texts_fragment, container, false)
        return binding.root
    }

}
