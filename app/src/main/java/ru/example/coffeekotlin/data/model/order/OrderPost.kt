package ru.example.coffeekotlin.data.model.order

data class OrderPost(
    val userToken:String,
    val product: List<Int>,
    val price:Int
)