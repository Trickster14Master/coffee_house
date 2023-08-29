package ru.example.coffeekotlin.presentation.registration_authentication
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.example.coffeekotlin.data.model.user.RegistrationUser
import ru.example.coffeekotlin.presentation.navigation.Graph
import ru.example.coffeekotlin.presentation.userInfoScreen.saveUserName
import ru.example.coffeekotlin.presentation.userInfoScreen.saveUserToken
import ru.example.coffeekotlin.ui.theme.Purple700

@Composable
fun Registration(
    navController: NavController
){
    Column(modifier = Modifier
        .padding(horizontal = 20.dp, vertical = 10.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        val registrationViewModel= hiltViewModel<RegistrationViewModel>()

        var name by remember{
            mutableStateOf("")
        }
        var password by remember{
            mutableStateOf("")
        }
        var mail by remember{
            mutableStateOf("")
        }


        OutlinedTextField(
            value =name, onValueChange = {newText->
            name=newText
        },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor=Color.White,
                unfocusedBorderColor  = Color.White,
                focusedBorderColor= Color.White,
            ),
            label = { Text(text = "Введите имя пользователя", color = Color.White, fontSize=10.sp)},
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
                textColor=Color.White,
                unfocusedBorderColor  = Color.White,
                focusedBorderColor= Color.White,
            ),
            label = { Text(text = "Пароль", color = Color.White, fontSize=10.sp)},
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

        OutlinedTextField(
            value =mail, onValueChange = {newText->
                mail=newText
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor=Color.White,
                unfocusedBorderColor  = Color.White,
                focusedBorderColor= Color.White,
            ),
            label = { Text(text = "Mail", color = Color.White, fontSize=10.sp)},
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

        Button(
            modifier= Modifier
                .padding(top = 50.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Purple700),
            shape = RoundedCornerShape(12.dp),

            onClick = {
                navController.navigate(Graph.AUTHENTICATION)
                registrationViewModel.registration(RegistrationUser(mail, name, password))
                //saveUserName(name)
            }
        ) {
            Text(text = "Зарегистрироваться", color=Color.White, modifier = Modifier.padding(vertical = 10.dp))
        }



    }
}