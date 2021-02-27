package com.liangjun.puppyadoption.presentation

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.liangjun.puppyadoption.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {

    @Composable
    abstract fun BuildView()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val isDark = (requireActivity().resources.configuration.uiMode
                and Configuration.UI_MODE_NIGHT_YES) != 0
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme(
                    darkTheme = isDark
                ) {
                    BuildView()
                }
            }
        }
    }
}