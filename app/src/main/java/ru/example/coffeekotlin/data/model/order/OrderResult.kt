package ru.example.coffeekotlin.data.model.order

import ru.example.coffeekotlin.data.model.product.ProductResult

// класс для хранения данных который в дальнейшем будет заполняться данными с API
data class OrderResult(
    // поле класса которое будет заполнено токеном пользователя
    val userToken: String,
    // поле класса которое будет заполнено датой сделанного заказа
    val date: String,
    // поле класса которое будет заполнено списком заказов, по умолчанию равно пустому списку
    val product: List<ProductResult> = emptyList(),
    // поле класса которое будет заполнено ценой заказа
    val price:Int
)
