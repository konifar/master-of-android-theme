package com.konifar.moat.materialcomponents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.konifar.moat.R
import com.konifar.moat.databinding.MaterialComponentsButtonsAndTextsFragmentBinding

class MaterialComponentsButtonAndTextsFragment : Fragment() {

    companion object {
        fun newInstance() = MaterialComponentsButtonAndTextsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: MaterialComponentsButtonsAndTextsFragmentBinding = DataBindingUtil.inflate(layoutInflater, R.layout.material_components_buttons_and_texts_fragment, container, false)
        return binding.root
    }

}
