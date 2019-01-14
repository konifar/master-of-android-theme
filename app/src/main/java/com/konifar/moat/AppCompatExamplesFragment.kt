package com.konifar.moat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.ContextThemeWrapper
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
        val contextThemeWrapper = ContextThemeWrapper(activity, getCurrentTheme())
        val localInflater = inflater.cloneInContext(contextThemeWrapper)
        val binding: AppcompatExamplesFragmentBinding = DataBindingUtil.inflate(localInflater, R.layout.appcompat_examples_fragment, container, false)
        return binding.root
    }

    private fun getCurrentTheme(): Int {
        return context?.let {
            val config = ThemeConfigManager.getCurrentConfig(it)
            config.appCompatThemeResId
        } ?: R.style.MoatAppCompatTheme_CatColorful
    }
}
