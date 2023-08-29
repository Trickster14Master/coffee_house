package ru.example.coffeekotlin.presentation.registration_authentication
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.example.coffeekotlin.data.model.user.RegistrationUser
import ru.example.coffeekotlin.domain.usecase.user_usecase.RegistrationUserUseCase
import javax.inject.Inject


@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val registrationUserUseCase: RegistrationUserUseCase
): ViewModel(){

    fun registration(user:RegistrationUser){
        viewModelScope.launch{
            registrationUserUseCase.invoke(user = user).let {
            }
        }
    }
}