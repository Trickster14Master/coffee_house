package ru.example.coffeekotlin.presentation.userInfoScreen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import ru.example.coffeekotlin.data.model.product.ProductResult
import ru.example.coffeekotlin.presentation.productScreen.listProduct
import ru.example.coffeekotlin.ui.theme.Purple500
import ru.example.coffeekotlin.ui.theme.button1Background

@ExperimentalMaterialApi
@Composable
fun UserOrderItem(item: ProductResult) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 2.dp, horizontal = 3.dp),
        border = BorderStroke(2.dp, Color.White),
        shape= RoundedCornerShape(20.dp),
        elevation=5.dp,
        backgroundColor = Purple500,
        contentColor= Color.White,

        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 10.dp, horizontal = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .size(75.dp, 75.dp)
                    .clip(CircleShape),
                model = item.urlsImage,
                contentDescription = "im5q",
            )
            Text(text = item.name)
            Text(text = "${item.price}р")
        }
    }
}