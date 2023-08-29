package ru.example.coffeekotlin.presentation.homeScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import ru.example.coffeekotlin.R
import ru.example.coffeekotlin.presentation.navigation.BottomNavItem
import ru.example.coffeekotlin.presentation.navigation.BottomNavigationBar
import ru.example.coffeekotlin.presentation.navigation.navigation
import ru.example.coffeekotlin.ui.theme.CoffeeKotlinTheme
import ru.example.coffeekotlin.ui.theme.Purple200

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(){
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentColor = Purple200,
        backgroundColor = Purple200,
        bottomBar={
            BottomNavigationBar(
                item = listOf(
                    BottomNavItem(name = "Товары", route = "list_product", icon = R.drawable.coffee),
                    BottomNavItem(name = "Корзина", route = "list_order", icon = R.drawable.basket),
                    BottomNavItem(name = "Пользователь", route = "user_info", icon = R.drawable.user),
                ),
                navController =navController,
                onItemClick ={
                    navController.navigate(it.route)
                }
            )
        }
    ) {
        navigation(navController = navController)
    }



}