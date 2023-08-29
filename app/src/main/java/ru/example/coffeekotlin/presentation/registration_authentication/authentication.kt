package ru.example.coffeekotlin.presentation.registration_authentication
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.example.coffeekotlin.data.model.user.AuthUser
import ru.example.coffeekotlin.presentation.navigation.Graph
import ru.example.coffeekotlin.presentation.userInfoScreen.saveUserName
import ru.example.coffeekotlin.presentation.userInfoScreen.saveUserToken
import ru.example.coffeekotlin.ui.theme.Purple700

@Composable
fun Authentication(
    navController: NavController
){
    var name by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }

    val authenticationUserViewModel= hiltViewModel<AuthenticationUserViewModel>()
    val token=authenticationUserViewModel.userToken.observeAsState().value?.data

    Column(modifier = Modifier
        .padding(horizontal = 20.dp, vertical = 10.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        OutlinedTextField(
            value =name, onValueChange = {newText->
                name=newText
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor= Color.White,
                unfocusedBorderColor  = Color.White,
                focusedBorderColor= Color.White,
            ),
            label = { Text(text = "Введите имя пользователя", color = Color.White, fontSize=10.sp) },
            leadingIcon = {
                IconButton(onClick = { }, ) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "name",
                        tint = Color.White

                    )

                }
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Ascii,
                imeAction = ImeAction.Go
            ),
        )

        OutlinedTextField(value =password, onValueChange = {newText->
            password=newText
        },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor= Color.White,
                unfocusedBorderColor  = Color.White,
                focusedBorderColor= Color.White,
            ),
            label = { Text(text = "Пароль", color = Color.White, fontSize=10.sp) },
            leadingIcon = {
                IconButton(onClick = { }, ) {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "name",
                        tint = Color.White
                    )

                }
            },
            singleLine = true
        )

        Button(
            modifier= Modifier
                .padding(top = 70.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Purple700),
            shape = RoundedCornerShape(12.dp),

            onClick = {
                // захардкодил так как не хотел каждый раз писать в ручную
                authenticationUserViewModel.authUser(AuthUser(password, name))
                saveUserName(name)
                Thread.sleep(3000)
                navController.navigate(Graph.HOME)
            }
        ) {
            Text(text = "Войти в аккаунт", color= Color.White, modifier = Modifier.padding(vertical = 10.dp))
        }

        Button(
            modifier= Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Purple700),
            shape = RoundedCornerShape(12.dp),

            onClick = {
                navController.navigate(Graph.REGISTRATION)
            }
        ) {
            Text(text = "Зарегистрировать аккаунт", color= Color.White, modifier = Modifier.padding(vertical = 10.dp))
        }


    }
}