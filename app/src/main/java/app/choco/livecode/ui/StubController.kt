package app.choco.livecode.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import app.choco.livecode.databinding.ItemStubBinding
import app.choco.livecode.ui.misc.SimpleController

class StubController : SimpleController<Any, ItemStubBinding>() {

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup) =
        ItemStubBinding.inflate(inflater, parent, false)

    override fun bindView(data: Any, binding: ItemStubBinding) = with(binding) {
        text.text = data::class.java.name
    }

    override fun isSuitable(data: Any) = true

}
