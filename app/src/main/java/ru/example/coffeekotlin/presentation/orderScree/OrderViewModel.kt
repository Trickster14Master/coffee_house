package ru.example.coffeekotlin.presentation.orderScree

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.example.coffeekotlin.data.model.order.OrderPost
import ru.example.coffeekotlin.domain.usecase.order_usecase.PostOrderUseCase
import ru.example.coffeekotlin.presentation.productScreen.listID
import ru.example.coffeekotlin.presentation.productScreen.listProduct
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
     private val postOrderUseCase: PostOrderUseCase
):ViewModel() {
    fun postOrder(body: OrderPost){
        viewModelScope.launch {
            postOrderUseCase.invoke(body = body)
            listProduct.clear()

        }
    }
}