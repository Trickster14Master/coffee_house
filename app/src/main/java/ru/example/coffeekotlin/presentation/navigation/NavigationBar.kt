package ru.example.coffeekotlin.presentation.navigation
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.example.coffeekotlin.presentation.orderScree.OrderScreen
import ru.example.coffeekotlin.presentation.productScreen.ProductScreen
import ru.example.coffeekotlin.presentation.userInfoScreen.UserInfoScreen
import ru.example.coffeekotlin.ui.theme.button1Background
import ru.example.coffeekotlin.ui.theme.button2Background


@ExperimentalMaterialApi
@Composable
fun navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = "list_product" ){
        composable("list_product"){
            ProductScreen()
        }
        composable("list_order"){
            OrderScreen(navController=navController)
        }
        composable("user_info"){
            UserInfoScreen(navController=navController)
        }
        composable("rootNavigationGraph"){
            RootNavigationGraph(navController = rememberNavController())
        }
    }
}


@Composable
fun BottomNavigationBar(
    item: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier=Modifier,
    onItemClick: (BottomNavItem)->Unit
){
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier=modifier,
        backgroundColor = button2Background,
        elevation = 5.dp
    ) {
        item.forEach{item->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = button1Background,
                unselectedContentColor = Color.White,
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        Icon(painter = painterResource(id = item.icon) , contentDescription = null)
                        if (selected){
                            Text(text = item.name, color = Color.White, fontSize = 13.sp)
                        }
                    }   
                }
            )
        }
    }
}