package ru.example.coffeekotlin.presentation.registration_authentication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.example.coffeekotlin.data.model.user.AuthUser
import ru.example.coffeekotlin.data.model.user.UserToken
import ru.example.coffeekotlin.domain.usecase.user_usecase.AuthUserUserCase
import ru.example.coffeekotlin.presentation.userInfoScreen.saveUserToken
import ru.example.coffeekotlin.util.Resource
import javax.inject.Inject

@HiltViewModel
class AuthenticationUserViewModel @Inject constructor(
    private val authUserUserCase: AuthUserUserCase
): ViewModel()  {
    private val _userToken = MutableLiveData<Resource<UserToken>>()
    val userToken:LiveData<Resource<UserToken>>
        get() = _userToken


    fun authUser(user: AuthUser){
        viewModelScope.launch {
            authUserUserCase.invoke(user = user).let {
                Log.d("User", it.data?.auth_token ?: "gecnj")
                saveUserToken(it.data!!.auth_token )
            }
        }
    }

}