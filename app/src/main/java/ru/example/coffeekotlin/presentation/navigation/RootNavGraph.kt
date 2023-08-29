package ru.example.coffeekotlin.presentation.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.example.coffeekotlin.presentation.homeScreen.HomeScreen
import ru.example.coffeekotlin.presentation.registration_authentication.Authentication
import ru.example.coffeekotlin.presentation.registration_authentication.Registration

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Graph.AUTHENTICATION
    ) {
        // composable отвечает за то чтобы перейти на экран если в composable был передан url адрес
        composable(route= Graph.REGISTRATION){
            Registration(navController=navController)
        }
        composable(route= Graph.AUTHENTICATION){
            Authentication(navController=navController)
        }
        composable(route = Graph.HOME) {
            HomeScreen()
        }
    }
}

// что то типа url дреса
object Graph {
    const val REGISTRATION = "registration_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
}