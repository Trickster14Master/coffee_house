package ru.example.coffeekotlin.domain.usecase.order_usecase

import ru.example.coffeekotlin.data.model.order.OrderPost
import ru.example.coffeekotlin.data.repository.OrderRepository
import javax.inject.Inject

class PostOrderUseCase @Inject constructor(
    private val orderRepository: OrderRepository
){
    suspend fun invoke(body:OrderPost)=orderRepository.postOrder(body=body)
}