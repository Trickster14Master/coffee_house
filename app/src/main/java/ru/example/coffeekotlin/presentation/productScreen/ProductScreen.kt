package ru.example.coffeekotlin.presentation.productScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.example.coffeekotlin.data.model.product.ProductResult
import ru.example.coffeekotlin.presentation.commonScreen.ErrorScreens
import ru.example.coffeekotlin.presentation.commonScreen.LoadingScreen
import ru.example.coffeekotlin.ui.theme.Teal200
import ru.example.coffeekotlin.util.Resource
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.example.coffeekotlin.ui.theme.Purple500
import ru.example.coffeekotlin.ui.theme.Purple700

@ExperimentalMaterialApi
@Composable
fun ProductScreen(){
    // создаём экземпляр класса ViewModel который будет предоставлять данные и изменять интерфейс
    val productViewModel= hiltViewModel<ProductViewModel>()
    // тут мы создаём переменную которая будет хранить состояние в зависимости от того что находится в ViewModel
    val state = productViewModel.productResponse.observeAsState().value ?: Resource.Loading()

    // when позволяет сравнивать внутри себя переданный объект с другим объектом
    when(state) {
        // выводим ProductSuccessScreen если state равен Resource.Success
        is Resource.Success -> {
            // выводим экран ProductSuccessScreen и передаём в него данные и ViewModel
            ProductSuccessScreen(state.data ?: listOf(), productViewModel)
        }
        is Resource.Error -> {
            ErrorScreens(state.message?: "Oh, some error!")
        }
        is Resource.Loading -> {
            LoadingScreen()
        }
    }
}
var listProduct : MutableList<ProductResult> = arrayListOf()
var listID : MutableList<Int> = arrayListOf()

@ExperimentalMaterialApi
@Composable
fun ProductSuccessScreen(productResponse: List<ProductResult>, mainViewModel: ProductViewModel) {

    Column {

        Card(
            modifier= Modifier
                .padding(horizontal = 10.dp, vertical = 5.dp)
                .fillMaxWidth(),
            backgroundColor = Teal200,
            shape= RoundedCornerShape(12.dp)
        ) {
            Row(modifier= Modifier
                .padding(6.dp),
                horizontalArrangement = Arrangement.SpaceEvenly

            ){
                Button(
                    // указываем цвет
                    colors = ButtonDefaults.buttonColors(Purple500),
                    // указываем закругление у кнопок
                    shape = RoundedCornerShape(12.dp),
                    // вызываем ViewModel с запросом на напитки
                    onClick = {
                        mainViewModel.getDrink()
                    }
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        // получаем картинку из интернета
                        AsyncImage(
                            modifier = Modifier
                                .size(40.dp, 40.dp)
                                .clip(RoundedCornerShape(30)),
                            model = "http://217.71.129.139:4799/media/posts/coffee.png",
                            contentDescription = "im5",
                        )
                        // выводим текст
                        Text(text = "Напитки", color = Color.White)
                    }
                }

                Button(
                    colors = ButtonDefaults.buttonColors(Purple500),
                    shape = RoundedCornerShape(12.dp),
                    onClick = {
                        mainViewModel.getDessert()
                    }
                ) {
                    Column (
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally
                            ){
                        //Icon(imageVector = Icons.Default.Add, contentDescription = null)
                        AsyncImage(
                            modifier = Modifier
                                .size(40.dp, 40.dp)
                                .clip(RoundedCornerShape(30)),
                            model = "http://217.71.129.139:4799/media/posts/cookies_n58h9xz.png",
                            contentDescription = "im5",
                        )

                        Text(text = "Дессерты", color = Color.White)
                    }
                }

                Button(
                    colors = ButtonDefaults.buttonColors(Purple500),
                    shape = RoundedCornerShape(12.dp),
                    onClick = {
                        mainViewModel.getSyrup()
                    }
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        //Icon(imageVector = Icons.Default.Add, contentDescription = null)

                        AsyncImage(
                            modifier = Modifier
                                .size(40.dp, 40.dp)
                                .clip(RoundedCornerShape(30)),
                            model = "http://217.71.129.139:4799/media/posts/syrup_ePzb1ou.png",
                            contentDescription = "im5",
                        )

                        Text(text = "Топпинги", color = Color.White)
                    }
                }
            }

        }


            LazyColumn(modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, bottom = 60.dp )) {
                // items условное обозначение внутри Lazy Column для элемента который будет выводиться
                // в скобочках передаём product Response, это переменная которая несет внутри себя список Product Result
                // item конкретный элемент полученный из ProductResult
                items(productResponse) { item ->
                    // тут мы вызываем элемент который отвечает за отдельный элемент в LazyColumn и передаём в него элемент из списка ProductResult
                    ProductItem(item)
                }
            }
        }

}
