package com.liangjun.puppyadoption.presentation.ui.puppy

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.viewModels
import com.liangjun.puppyadoption.R
import com.liangjun.puppyadoption.presentation.BaseFragment
import com.liangjun.puppyadoption.presentation.components.CommonInfoText
import com.liangjun.puppyadoption.presentation.components.MyToolBar
import com.liangjun.puppyadoption.util.loadPicture
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PuppyFrag : BaseFragment() {

    private val viewModel: PuppyViewModel by viewModels()

    @Composable
    override fun BuildView() {
        Scaffold(
            topBar = {
                MyToolBar()
            }
        ) {
            Puppy()
        }
    }

    @Composable
    fun Puppy() {
        val id = requireArguments().getString("id", "")
        viewModel.init(id)

        val puppy = viewModel.puppy.value
        if (puppy != null) {
            Column {
                val image = loadPicture(url = puppy.featuredImage).value
                image?.let {
                    Image(
                        bitmap = it.asImageBitmap(),
                        contentDescription = "puppy",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .layoutId(R.id.iv_puppy_image)
                    )
                }
                Text(
                    text = puppy.name,
                    style = MaterialTheme.typography.h2.copy(fontSize = 22.sp),
                    modifier = Modifier.padding(start = 16.dp, top = 10.dp)
                )
                Spacer(modifier = Modifier.padding(top = 10.dp))
                CommonInfoText(
                    text = puppy.age.toString(),
                    modifier = Modifier.padding(start = 16.dp)
                )
                CommonInfoText(
                    text = puppy.gender,
                    modifier = Modifier.padding(start = 16.dp)
                )
                CommonInfoText(
                    text = puppy.breed,
                    modifier = Modifier.padding(start = 16.dp)
                )
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Text(
                    text = puppy.brief,
                    modifier = Modifier.padding(start = 16.dp)
                )
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(
                        color = if (puppy.adopted)
                            Color.LightGray
                        else
                            MaterialTheme.colors.surface,
                        shape = MaterialTheme.shapes.small
                    ),
                    enabled = puppy.adopted.not(),
                    onClick = {
                        Toast.makeText(requireContext(), "Do Adopt", Toast.LENGTH_SHORT).show()
                    }
                ) {
                    Text(text = if (puppy.adopted) "Adopted" else "Adopt me")
                }
            }
        }
    }
}