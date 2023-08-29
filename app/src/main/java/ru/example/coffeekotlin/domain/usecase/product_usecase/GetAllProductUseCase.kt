package ru.example.coffeekotlin.domain.usecase.product_usecase

import ru.example.coffeekotlin.data.repository.ProductRepository
import javax.inject.Inject
// UseCase который получает все продукты
class GetAllProductUseCase @Inject constructor(
    // получаем экземпляр класса репозитория благодаря инъекции зависимостей
    private val productRepository: ProductRepository
){
    // функция которая возвращает все продукты
    suspend fun invoke()=productRepository.getAllProduct()
}