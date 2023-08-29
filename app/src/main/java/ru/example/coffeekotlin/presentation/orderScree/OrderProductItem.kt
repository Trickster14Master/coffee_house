package ru.example.coffeekotlin.presentation.orderScree

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
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import ru.example.coffeekotlin.data.model.product.ProductResult
import ru.example.coffeekotlin.presentation.productScreen.listProduct
import ru.example.coffeekotlin.ui.theme.Purple500
import ru.example.coffeekotlin.ui.theme.button1Background

@ExperimentalMaterialApi
@Composable
fun OrderProductItem(item: ProductResult, navController: NavController) {
    var expandedShape by remember{ mutableStateOf(false) }


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp)
            .animateContentSize(
                animationSpec = tween(
                    delayMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        border = BorderStroke(2.dp, Color.White),
        shape= RoundedCornerShape(20.dp),
        onClick = {
            expandedShape = !expandedShape
        } ,
        elevation=5.dp,
        backgroundColor = Purple500,
        contentColor= Color.White,

        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            AsyncImage(
                modifier = Modifier
                    .size(100.dp, 100.dp)
                    .weight(3f)
                    .clip(CircleShape),
                model = item.urlsImage,
                contentDescription = "im5",
            )

            Column(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .weight(5f)
            ) {
                Text(text = item.name,
                    modifier= Modifier.align(Alignment.CenterHorizontally),
                    fontSize = MaterialTheme.typography.h6.fontSize ,
                    fontWeight = FontWeight.Bold)

                Row(modifier= Modifier
                    .fillMaxWidth()
                    .padding(top=3.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(text = "Цена: ${item.price}p", modifier = Modifier.padding(top = 7.dp),fontSize = MaterialTheme.typography.h6.fontSize)

                    IconButton(
                        //modifier = Modifier.padding(start = 40.dp),
                        onClick = {
                            listProduct.removeAt(listProduct.indexOf(item))
                            navController.navigate("list_order")
                            }) {
                        Icon(
                            modifier = Modifier.size(40.dp),
                            tint= button1Background,
                            imageVector = Icons.Default.Delete,
                            contentDescription = null
                        )
                    }
                }
            }



        }
    }
}