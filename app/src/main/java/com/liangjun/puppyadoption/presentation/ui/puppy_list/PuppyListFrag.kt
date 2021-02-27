package com.liangjun.puppyadoption.presentation.ui.puppy_list

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController
import com.liangjun.puppyadoption.R
import com.liangjun.puppyadoption.presentation.BaseFragment
import com.liangjun.puppyadoption.presentation.components.MyToolBar
import com.liangjun.puppyadoption.presentation.components.PuppyCard
import com.liangjun.puppyadoption.presentation.components.ShimmerCardPreview
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PuppyListFrag : BaseFragment() {

    private val viewModel: PuppyListViewModel by viewModels()

    @Composable
    override fun BuildView() {
        Scaffold(
            topBar = {
                MyToolBar()
            }
        ) {
            PuppyList()
        }
    }

    @Composable
    fun PuppyList() {
        val puppies = viewModel.puppies.value

        val loading = viewModel.loading.value

        if (loading) {
            ShimmerCardPreview()
        } else {
            LazyColumn(
                modifier = Modifier.background(color = MaterialTheme.colors.background)
            ) {
                items(count = puppies.size) {
                    PuppyCard(puppy = puppies[it], onClick = {
                        val bundle = Bundle().apply {
                            putString("id", it)
                        }
                        findNavController().navigate(R.id.toPuppyDetail, bundle)
                    })
                }
            }
        }
    }
}