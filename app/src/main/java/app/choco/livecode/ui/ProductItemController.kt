package app.choco.livecode.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import app.choco.livecode.R
import app.choco.livecode.data.ProductDto
import app.choco.livecode.databinding.ItemProductBinding
import app.choco.livecode.ui.misc.SimpleController
import app.choco.livecode.ui.misc.resources

class ProductItemController(
    private val onButtonClicked: (ProductDto) -> Unit
) : SimpleController<ProductDto, ItemProductBinding>() {

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup) =
        ItemProductBinding.inflate(inflater, parent, false)

    override fun bindView(data: ProductDto, binding: ItemProductBinding) = with(binding) {
        productName.text = data.name
        productDescription.text = data.description
        productPrice.text = resources.getString(R.string.price_format, data.price)
        productBtn.setOnClickListener { onButtonClicked(data) }
    }

}
