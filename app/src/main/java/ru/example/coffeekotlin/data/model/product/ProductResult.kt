package ru.example.coffeekotlin.data.model.product

data class ProductResult(
    val id: Int=0,
    var name: String="",
    val description: String="",
    val type: String="",
    val price: Int=0,
    val volume: Int=0,
    val urlsIcon: String="",
    val urlsImage: String="",
)