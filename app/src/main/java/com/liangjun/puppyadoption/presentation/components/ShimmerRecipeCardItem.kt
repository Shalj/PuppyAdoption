package com.liangjun.puppyadoption.presentation.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ShimmerCardPreview() {
    BoxWithConstraints {
        val count = 4
        val cardHeight = 200.dp
        LazyColumn(
            modifier = Modifier.background(color = Color.White),
            content = {
                items(count = count) {
                    BoxWithConstraints(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 10.dp)
                    ) {
                        ShimmerRecipeCard(
                            colors = listOf(
                                Color.LightGray.copy(alpha = .9f),
                                Color.LightGray.copy(alpha = .2f),
                                Color.LightGray.copy(alpha = .9f),
                            ), maxWidth = maxWidth, cardHeight = cardHeight
                        )
                    }
                }
            })
    }
}

@Composable
fun ShimmerRecipeCard(
    colors: List<Color>,
    maxWidth: Dp,
    cardHeight: Dp
) {
    //将宽由Dp转化为像素
    val widthPx = with(LocalDensity.current) {
        maxWidth.toPx()
    }
    //将高由Dp转化为像素
    val heightPx = with(LocalDensity.current) {
        cardHeight.toPx()
    }
    //找出宽高较大者 使其以45度运动
    val maxOffset = if (widthPx > heightPx) widthPx else heightPx
    //渐变区域宽度
    val gradientWidth = 100f
    //创建无限循环动画transition
    val infiniteTransition = rememberInfiniteTransition()
    //通过transition代理，实时更新偏移量
    val offset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = maxOffset + gradientWidth,
        animationSpec =
        infiniteRepeatable(
            animation = tween(
                durationMillis = 1200,
                delayMillis = 300,
                easing = LinearEasing
            )
        )
    )
    //用于控制倾斜角度 当tiltRadius为1时 线为45度
    val tiltRadius = .3f
    //渐变区域颜色
    val brush = Brush.linearGradient(
        colors = colors,
        start = Offset(offset - gradientWidth, (offset - gradientWidth) * tiltRadius),
        end = Offset(offset, offset * tiltRadius)
        //y固定为0即为横向刷，反之则纵向刷
//        start = Offset(offset - gradientWidth, 0f),
//        end = Offset(offset, 0f)
//        start = Offset(0f, offset - gradientWidth),
//        end = Offset(0f, offset)
    )

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.small
    ) {
        Spacer(
            modifier = Modifier
                .background(brush = brush)
                .fillMaxWidth()
                .height(cardHeight)
        )
    }
}