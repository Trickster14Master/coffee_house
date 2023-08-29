package ru.example.coffeekotlin.presentation.productScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.example.coffeekotlin.data.model.product.ProductResult
import ru.example.coffeekotlin.domain.usecase.product_usecase.GetAllProductUseCase
import ru.example.coffeekotlin.domain.usecase.product_usecase.GetDessertUseCase
import ru.example.coffeekotlin.domain.usecase.product_usecase.GetDrinkUseCase
import ru.example.coffeekotlin.domain.usecase.product_usecase.GetSyrupUseCase
import ru.example.coffeekotlin.util.Resource
import javax.inject.Inject


@HiltViewModel
class ProductViewModel @Inject constructor(
    // получаем зависимости от UseCase
    private val getDessertUseCase: GetDessertUseCase,
    private val getDrinkUseCase: GetDrinkUseCase,
    private val getSyrupUseCase:GetSyrupUseCase,
):ViewModel(){
    // переменная _productResponse будет хранить данные внутри ViewModel, а productResponse будет предоставлять данные уже на экране
    private val _productResponse = MutableLiveData<Resource<List<ProductResult>>>()
    val productResponse:LiveData<Resource<List<ProductResult>>>
        get() = _productResponse

    // тут указывается какая функция будет вызвана при инициализации ViewModel
    init {
        getDrink()
    }

    // функция по получению всех напитков
    fun getDrink(){
        // с помощью viewModelScope создаём отдельный поток
        viewModelScope.launch {
            // вызываем функцию из UseCase
            getDrinkUseCase.invoke().let {
                // присваиваем пришедшее значение в переменную
                _productResponse.value=it
            }
        }
    }

    fun getDessert(){
        viewModelScope.launch {
            getDessertUseCase.invoke().let {
                _productResponse.value=it
            }
        }
    }

    fun getSyrup(){
        viewModelScope.launch {
            getSyrupUseCase.invoke().let {
                _productResponse.value=it
            }
        }
    }
}