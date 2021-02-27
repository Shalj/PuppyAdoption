package com.liangjun.puppyadoption.presentation.components

import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.liangjun.puppyadoption.R

@Composable
fun MyToolBar(
    title: String = stringResource(id = R.string.app_name)
) {

    TopAppBar(
        title = {
            Text(text = title)
        },
        modifier = Modifier.background(MaterialTheme.colors.primary)
    )
}