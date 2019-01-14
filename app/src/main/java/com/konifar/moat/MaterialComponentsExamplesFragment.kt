package com.konifar.moat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.ContextThemeWrapper
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.konifar.moat.databinding.MaterialComponentsExamplesFragmentBinding

class MaterialComponentsExamplesFragment : Fragment() {

    companion object {
        fun newInstance() = MaterialComponentsExamplesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contextThemeWrapper = ContextThemeWrapper(activity, R.style.AppTheme_Material)
        val localInflater = inflater.cloneInContext(contextThemeWrapper)
        val binding: MaterialComponentsExamplesFragmentBinding = DataBindingUtil.inflate(localInflater, R.layout.material_components_examples_fragment, container, false)
        return binding.root
    }
}
