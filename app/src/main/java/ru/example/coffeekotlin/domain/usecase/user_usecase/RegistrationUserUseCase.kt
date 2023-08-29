package ru.example.coffeekotlin.domain.usecase.user_usecase

import ru.example.coffeekotlin.data.model.user.RegistrationUser
import ru.example.coffeekotlin.data.repository.OrderRepository
import ru.example.coffeekotlin.data.repository.UserRepository
import javax.inject.Inject

class RegistrationUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend fun invoke(user:RegistrationUser)=userRepository.registrationUser(user=user)
}