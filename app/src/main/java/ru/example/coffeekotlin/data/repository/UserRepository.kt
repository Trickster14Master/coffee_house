package ru.example.coffeekotlin.data.repository
import ru.example.coffeekotlin.data.model.user.AuthUser
import ru.example.coffeekotlin.data.model.user.RegistrationUser
import ru.example.coffeekotlin.data.model.user.ResponseRegistrationUser
import ru.example.coffeekotlin.data.model.user.UserToken
import ru.example.coffeekotlin.data.remote.StockApi
import ru.example.coffeekotlin.util.BaseApiResponse
import ru.example.coffeekotlin.util.Resource
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userService: StockApi
): BaseApiResponse() {
    suspend fun registrationUser(user: RegistrationUser): Resource<ResponseRegistrationUser>{
        return safeApiCall { userService.registrationUser(user) }
    }

    suspend fun authenticationUser(user: AuthUser):Resource<UserToken>{
        return safeApiCall { userService.authUser(user) }
    }

}