package com.liangjun.puppyadoption.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.liangjun.puppyadoption.domain.model.Puppy
import com.liangjun.puppyadoption.util.loadPicture
import com.liangjun.puppyadoption.R

@Preview
@Composable
fun PuppyCardPreview() {
    PuppyCard(
        Puppy(
            id = "0",
            name = "name",
            age = 0,
            featuredImage = "",
            createTime = "",
            adopted = false,
            breed = "hhh",
            gender = "female",
            brief = ""
        ),
        onClick = {}
    )
}

@Composable
fun PuppyCard(
    puppy: Puppy,
    onClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable {
                onClick(puppy.id)
            },
        shape = MaterialTheme.shapes.medium,
        elevation = 8.dp
    ) {
        Column {
            val image = loadPicture(url = puppy.featuredImage).value
            image?.let { img ->
                Image(
                    bitmap = img.asImageBitmap(),
                    contentDescription = "puppy image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .layoutId(R.id.iv_puppy_image),
                    contentScale = ContentScale.Crop
                )
            }

            Text(
                text = puppy.name,
                style = MaterialTheme.typography.h2.copy(fontSize = 22.sp),
                modifier = Modifier
                    .padding(start = 8.dp, top = 10.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CommonInfoText(text = "age: ${puppy.age}")
                CommonInfoText(text = "gender: ${puppy.gender}")
                CommonInfoText(text = "breed: ${puppy.breed}")
            }
        }

        if (puppy.adopted) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "ADOPTED",
                    style = TextStyle(
                        color = Color.Red,
                        fontSize = 22.sp
                    ),
                    modifier = Modifier
                        .rotate(30f)
                        .align(Alignment.TopEnd)
                        .padding(top = 16.dp)
                        .border(
                            width = 1.dp,
                            shape = MaterialTheme.shapes.small,
                            color = Color.Red
                        )
                )
            }
        }
    }
}