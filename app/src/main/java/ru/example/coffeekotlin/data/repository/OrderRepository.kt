package ru.example.coffeekotlin.data.repository

import ru.example.coffeekotlin.data.model.order.OrderPost
import ru.example.coffeekotlin.data.model.order.OrderResult
import ru.example.coffeekotlin.data.remote.RemoteDataSourceOrder
import ru.example.coffeekotlin.util.BaseApiResponse
import ru.example.coffeekotlin.util.Resource
import javax.inject.Inject

class OrderRepository @Inject constructor(
    private val api: RemoteDataSourceOrder
): BaseApiResponse() {

    suspend fun postOrder(body: OrderPost): Resource<OrderPost> {
        return safeApiCall{api.postOrder(body=body)}
    }

    suspend fun getOrder(userToken:String): Resource<List<OrderResult>> {
        return safeApiCall { api.getOrder(userToken=userToken) }
    }
}