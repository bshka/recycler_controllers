package app.choco.livecode.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import app.choco.livecode.databinding.ItemImageBinding
import app.choco.livecode.ui.misc.SimpleController

data class ImageItem(
    @DrawableRes val image: Int
)

class ImageItemController : SimpleController<ImageItem, ItemImageBinding>() {

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup) =
        ItemImageBinding.inflate(inflater, parent, false)

    override fun bindView(data: ImageItem, binding: ItemImageBinding) = with(binding) {
        image.setImageResource(data.image)
    }

}
