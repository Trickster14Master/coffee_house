package ru.example.coffeekotlin

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.example.coffeekotlin.presentation.homeScreen.HomeScreen
import ru.example.coffeekotlin.presentation.navigation.BottomNavItem
import ru.example.coffeekotlin.presentation.navigation.BottomNavigationBar
import ru.example.coffeekotlin.presentation.navigation.RootNavigationGraph
import ru.example.coffeekotlin.presentation.navigation.navigation
import ru.example.coffeekotlin.presentation.registration_authentication.Authentication
import ru.example.coffeekotlin.presentation.userInfoScreen.prefUserEmail
import ru.example.coffeekotlin.presentation.userInfoScreen.prefUserName
import ru.example.coffeekotlin.presentation.userInfoScreen.prefUserPassword
import ru.example.coffeekotlin.presentation.userInfoScreen.prefUserToken
import ru.example.coffeekotlin.ui.theme.CoffeeKotlinTheme
import ru.example.coffeekotlin.ui.theme.Purple200

@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefUserName=getSharedPreferences("UserName", Context.MODE_PRIVATE)
        prefUserPassword=getSharedPreferences("UserPassword", Context.MODE_PRIVATE)
        prefUserEmail=getSharedPreferences("UserEmail", Context.MODE_PRIVATE)
        // инициализируем переменные для кэширования токена
        prefUserToken=getSharedPreferences("UserToken", Context.MODE_PRIVATE)

        setContent {
            CoffeeKotlinTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentColor = Purple200,
                    backgroundColor = Purple200,
                ) {
                    // получаем нынешнее значение токена
                    var userToken=prefUserToken?.getString("UserToken","")

                    // если переменная для хранения токена окажется пустой то вызываем экран аунтификации
                    if(userToken?.length==0){
                        RootNavigationGraph(navController = rememberNavController())
                    // если токен уже будет нести в себе значение то сразу обращаемся HomeScreen
                    }else{
                        HomeScreen()
                    }

                        //HomeScreen()
                }
            }
        }
    }
}


