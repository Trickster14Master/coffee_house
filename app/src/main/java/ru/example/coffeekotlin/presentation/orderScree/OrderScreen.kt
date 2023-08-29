package ru.example.coffeekotlin.presentation.orderScree

import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.example.coffeekotlin.data.model.order.OrderPost
import ru.example.coffeekotlin.presentation.productScreen.listID
import ru.example.coffeekotlin.presentation.productScreen.listProduct
import ru.example.coffeekotlin.presentation.userInfoScreen.prefUserToken
import ru.example.coffeekotlin.ui.theme.Purple500
import ru.example.coffeekotlin.ui.theme.Teal200
import ru.example.coffeekotlin.ui.theme.button2Background

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OrderScreen(navController:NavController){
    val orderViewModel= hiltViewModel<OrderViewModel>()
    var prise=0
    for(i in listProduct){
        listID.add(i.id)
        prise= prise+i.price
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp, bottom = 60.dp),
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        Card(
            modifier= Modifier
                .padding(horizontal = 10.dp, vertical = 5.dp)
                .fillMaxWidth(),
            backgroundColor = Teal200,
            shape= RoundedCornerShape(12.dp)
        ){
            LazyColumn {
                items(listProduct) { item ->
                    OrderProductItem(item, navController)
                }
            }
        }

    }

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 600.dp, bottom = 60.dp, start = 5.dp, end = 5.dp),
        backgroundColor = button2Background,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(2.dp, Color.White),
        onClick = {
            orderViewModel.postOrder(OrderPost(prefUserToken?.getString("UserToken","пусто").toString(), listID, prise))
            navController.navigate("user_info")
        }

    ) {
        Row(modifier = Modifier.padding(vertical = 20.dp)) {
            Text(text = "Сделать заказ на сумму: ${prise}р", textAlign = TextAlign.Center, modifier = Modifier.fillMaxSize(), color = Color.White)
        }
    }
}