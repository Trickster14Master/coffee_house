package ru.example.coffeekotlin.domain.usecase.product_usecase

import ru.example.coffeekotlin.data.repository.ProductRepository
import javax.inject.Inject

class GetSyrupUseCase @Inject constructor(
    private val productRepository: ProductRepository
){
    suspend fun invoke()=productRepository.getSyrup()
}