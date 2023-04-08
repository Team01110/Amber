package com.example.amber.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding>(
    private val bindingInflater
    : (layoutInflater: LayoutInflater) -> VB
) : Fragment() {

    protected abstract val vm: VM
    private var _binding: VB? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialize()
        listeners()
        setupRequest()
    }

    protected open fun initialize() {}
    protected open fun listeners() {}
    protected open fun setupRequest() {}
}