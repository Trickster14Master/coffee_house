package ru.example.coffeekotlin.presentation.userInfoScreen
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.example.coffeekotlin.data.model.order.OrderResult
import ru.example.coffeekotlin.ui.theme.Purple500
import ru.example.coffeekotlin.ui.theme.Purple700
import ru.example.coffeekotlin.util.Resource

@Composable
fun UserInfoScreen(navController: NavController){
    val userOrder= hiltViewModel<UserInfoViewModel>()
    val stateUserInfo = userOrder.getOrderResponse.observeAsState().value?: Resource.Loading()
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp, bottom = 60.dp),
    ) {
        Card(
            modifier= Modifier
                .padding(vertical = 5.dp)
                .fillMaxWidth()
                .size(100.dp),
            backgroundColor = Purple500,
            shape= RoundedCornerShape(12.dp),
            border = BorderStroke(2.dp, Color.White),

        ){
            Row(modifier = Modifier
                .padding(vertical = 4.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(Icons.Default.Person, contentDescription = null, Modifier.size(80.dp), tint = Color.White)
                Column (
                    verticalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxSize()
                        ){
                    Text(text = "Имя: ${prefUserName?.getString("UserName","пусто")}", fontSize = 15.sp, maxLines = 1, color = Color.White)
                    Text(text = "Количество заказов: ${stateUserInfo.data?.size}", fontSize = 15.sp, color = Color.White)
                }
            }
        }

        Button(
            modifier= Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Purple700),
            shape = RoundedCornerShape(12.dp),

            onClick = {
                saveUserToken("")
                Thread.sleep(1000)
                obnul(context)
            }
        ) {
            Text(text = "Выйти из аккаунта", color= Color.White, modifier = Modifier.padding(vertical = 10.dp))
        }

        ListOrderUser(stateUserInfo.data?: listOf())
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListOrderUser(order:List<OrderResult>){
    LazyColumn{
        items(order){i -> val item = i.product
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp),
                border = BorderStroke(2.dp, Color.White),
                shape= RoundedCornerShape(20.dp),
                elevation=5.dp,
                backgroundColor = Purple500,
                contentColor=Color.White,

                ) {
                    Column(modifier = Modifier.padding(horizontal = 6.dp, vertical = 6.dp)) {
                        Text(text = "Дата заказа ${i.date.substring(0,10)}")
                        Text(text = "Сумма заказа: ${i.price}")
                        LazyRow(){
                            items(item){itemOrder->
                                UserOrderItem(itemOrder)
                            }
                        }
                    }
            }
        }
    }
}

fun obnul(context: Context){
        val packageManager: PackageManager = context.packageManager
        val intent: Intent = packageManager.getLaunchIntentForPackage(context.packageName)!!
        val componentName: ComponentName = intent.component!!
        val restartIntent: Intent = Intent.makeRestartActivityTask(componentName)
        context.startActivity(restartIntent)
        Runtime.getRuntime().exit(0)
}

