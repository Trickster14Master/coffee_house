package ru.example.coffeekotlin.data.remote
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import ru.example.coffeekotlin.data.model.order.OrderPost
import ru.example.coffeekotlin.data.model.order.OrderResult
import ru.example.coffeekotlin.data.model.product.ProductResult
import ru.example.coffeekotlin.data.model.user.*

// для того что бы написать запросы к API нужно написать интерфейс, так как библиотека Retrofit работает только с интерфейсами
interface StockApi {
    // сначала указываем с помощью анатации тип операции, после указываем относительный url
    @GET("Product/Product/")
    // после чего пишем suspend (асинхронную хункцию) функцию, и казываем тот тип данных который вернёт вызов функции
    suspend fun getAllProduct():Response<List<ProductResult>>

    // сначала указываем с помощью анатации тип операции, после указываем относительный url
    @POST("PostOrder/PostOrder/")
    // после чего пишем suspend (асинхронную хункцию) функцию, и казываем тот тип данных который вернёт вызов функции,
    // и с помощью аннотации @Body указываем ту модель которую отправим на API при вызове функции
    suspend fun postOrder(@Body orderPost: OrderPost):Response<OrderPost>

    @GET("Product/Product/?search=сироп")
    suspend fun getSyrup():Response<List<ProductResult>>

    @GET("Product/Product/?search=напиток")
    suspend fun getDrink():Response<List<ProductResult>>

    @GET("Product/Product/?search=десерт")
    suspend fun getDessert():Response<List<ProductResult>>

    @GET("Order/Order/")
    suspend fun getOrder(@Query("search") userToken:String):Response<List<OrderResult>>

    @POST("Coffee/auth/users/")
    suspend fun registrationUser(@Body registrationUser: RegistrationUser):Response<ResponseRegistrationUser>

    @POST("auth/token/login/")
    suspend fun authUser(@Body authUser: AuthUser): Response<UserToken>

}

