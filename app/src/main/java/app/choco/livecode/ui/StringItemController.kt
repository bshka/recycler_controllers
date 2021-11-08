package app.choco.livecode.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import app.choco.livecode.databinding.ItemStringBinding
import app.choco.livecode.ui.misc.SimpleController

class StringItemController : SimpleController<String, ItemStringBinding>() {

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup) =
        ItemStringBinding.inflate(inflater, parent, false)

    override fun bindView(data: String, binding: ItemStringBinding) = with(binding) {
        text.text = data
    }

}
