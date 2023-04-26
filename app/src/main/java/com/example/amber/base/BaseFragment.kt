package com.example.amber.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.example.amber.fragment.utils.UiState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment<VB : ViewBinding>(
    private val bindingInflater
    : (layoutInflater: LayoutInflater) -> VB
) : Fragment() {

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

    protected fun <T> StateFlow<UiState<T>>.collectState(
        onLoading: () -> Unit,
        onError: (String) -> Unit,
        onSuccess: (T) -> Unit

    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                this@collectState.collect {
                    when (it) {
                        is UiState.Empty -> {}
                        is UiState.Error -> {
                            onError(it.msg)
                        }
                        is UiState.Loading -> {
                            onLoading()
                        }
                        is UiState.Success -> {
                            if (it.data != null)
                                onSuccess(it.data)
                        }
                    }
                }
            }
        }
    }
}