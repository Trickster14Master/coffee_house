package ru.example.coffeekotlin.data.remote

import ru.example.coffeekotlin.data.model.order.OrderPost
import ru.example.coffeekotlin.data.model.user.AuthUser
import javax.inject.Inject
// в данном классе находятся функции для вызова запросов к API
// с помощью @Inject constructor() мы получаем экземпляр интерфейса с запросами к API
class RemoteDataSourceProduct @Inject constructor(private val productService:StockApi){
    // асинхронная функция вызывающая запрос к API
    suspend fun getAllProduct()=productService.getAllProduct()
    suspend fun getDessert()=productService.getDessert()
    suspend fun getSyrup()=productService.getSyrup()
    suspend fun getDrink()=productService.getDrink()
}

class RemoteDataSourceOrder @Inject constructor(private val productService:StockApi){
    suspend fun postOrder(body: OrderPost)=productService.postOrder(body)
    suspend fun getOrder(userToken:String)=productService.getOrder(userToken=userToken)
}


