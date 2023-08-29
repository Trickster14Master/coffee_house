package ru.example.coffeekotlin.data.repository
import ru.example.coffeekotlin.data.model.product.ProductResult
import ru.example.coffeekotlin.data.remote.RemoteDataSourceProduct
import ru.example.coffeekotlin.util.BaseApiResponse
import ru.example.coffeekotlin.util.Resource

import javax.inject.Inject

// Repository как правило пределяеться откуда брать данные, тобишь брать данные с удалённой базы данных или же с локальной
class ProductRepository @Inject constructor(
    private val api:RemoteDataSourceProduct
):BaseApiResponse() {
    suspend fun getAllProduct():Resource<List<ProductResult>>{
        return safeApiCall { api.getAllProduct() }
    }

    suspend fun getDessert():Resource<List<ProductResult>>{
        return safeApiCall { api.getDessert() }
    }

    suspend fun getSyrup():Resource<List<ProductResult>>{
        return safeApiCall { api.getSyrup() }
    }

    suspend fun getDrink():Resource<List<ProductResult>>{
        return safeApiCall { api.getDrink() }
    }
}
