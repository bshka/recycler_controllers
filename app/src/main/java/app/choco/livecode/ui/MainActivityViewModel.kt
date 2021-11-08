package app.choco.livecode.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.choco.livecode.LoadProductsUseCase
import app.choco.livecode.R
import app.choco.livecode.data.ProductDto
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val loadProductsUseCase: LoadProductsUseCase
) : ViewModel() {

    private val _listItemsLiveData = MutableLiveData<List<Any>>()
    val listItemsLiveData: LiveData<List<Any>>
        get() = _listItemsLiveData

    init {
        viewModelScope.launch {
            _listItemsLiveData.value = loadProductsUseCase.load().let {
                it.toMutableList<Any>().apply {
                    add("Hello, I'm a string item")
                    add("Hello, I'm a second string item")
                    add(ImageItem(R.drawable.product_item))
                    add("Hello, I'm a third string item")
                    add(123)
                }
            }
        }
    }

    fun onButtonClicked(product: ProductDto) {
        Log.d(MainActivityViewModel::class.java.simpleName, "Product clicked ${product.id}")
    }

}
