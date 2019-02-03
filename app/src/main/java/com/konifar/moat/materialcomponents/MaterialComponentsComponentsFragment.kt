package com.konifar.moat.materialcomponents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.konifar.moat.R
import com.konifar.moat.databinding.MaterialComponentsComponentsFragmentBinding

class MaterialComponentsComponentsFragment : Fragment() {

    companion object {
        fun newInstance() = MaterialComponentsComponentsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: MaterialComponentsComponentsFragmentBinding = DataBindingUtil.inflate(layoutInflater, R.layout.material_components_components_fragment, container, false)
        return binding.root
    }

}
