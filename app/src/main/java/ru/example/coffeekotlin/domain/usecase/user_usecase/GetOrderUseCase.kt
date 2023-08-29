package ru.example.coffeekotlin.domain.usecase.user_usecase

import ru.example.coffeekotlin.data.repository.OrderRepository
import javax.inject.Inject

class GetOrderUseCase @Inject constructor(
    private val orderRepository : OrderRepository
) {
    suspend fun invoke(userToken:String)=orderRepository.getOrder(userToken=userToken)
}