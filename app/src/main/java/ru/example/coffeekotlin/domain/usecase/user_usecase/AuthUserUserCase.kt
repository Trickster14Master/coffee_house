package ru.example.coffeekotlin.domain.usecase.user_usecase
import ru.example.coffeekotlin.data.model.user.AuthUser
import ru.example.coffeekotlin.data.repository.UserRepository
import javax.inject.Inject

class AuthUserUserCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend fun invoke(user: AuthUser)=userRepository.authenticationUser(user=user)
}