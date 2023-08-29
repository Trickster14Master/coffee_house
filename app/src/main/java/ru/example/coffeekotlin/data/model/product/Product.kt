package ru.example.coffeekotlin.data.model.product

data class Product(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<ProductResult>
)