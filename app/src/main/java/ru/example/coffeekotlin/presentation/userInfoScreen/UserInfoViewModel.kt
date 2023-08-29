package ru.example.coffeekotlin.presentation.userInfoScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.example.coffeekotlin.data.model.order.OrderResult
import ru.example.coffeekotlin.domain.usecase.user_usecase.GetOrderUseCase

import ru.example.coffeekotlin.util.Resource
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel @Inject constructor(
    private val getOrderUseCase: GetOrderUseCase
): ViewModel(){
    private val _getOrderResponse=MutableLiveData<Resource<List<OrderResult>>>()
    val getOrderResponse:LiveData<Resource<List<OrderResult>>>
        get() = _getOrderResponse

    init {
        getOrder()
    }

    private fun getOrder(){
        viewModelScope.launch{
            var tok = prefUserToken?.getString("UserToken","пусто")
            getOrderUseCase.invoke(tok.toString()).let {
                _getOrderResponse.value=it
            }
        }
    }
}