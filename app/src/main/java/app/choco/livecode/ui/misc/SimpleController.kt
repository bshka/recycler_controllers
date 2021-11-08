package app.choco.livecode.ui.misc

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class SimpleController<T : Any, E : ViewBinding> : Controller<T, SimpleController.SimpleViewHolder>() {

    private val typeClass by lazy {
        (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments.first() as Class<*>
    }

    protected abstract fun createBinding(inflater: LayoutInflater, parent: ViewGroup): E

    override fun createViewHolder(parent: ViewGroup) = SimpleViewHolder(
        createBinding(LayoutInflater.from(parent.context), parent)
    )

    override fun bindViewHolder(data: T, holder: SimpleViewHolder) = bindView(data, holder.binding as E)

    protected abstract fun bindView(data: T, binding: E)

    override fun onViewRecycled(holder: SimpleViewHolder) = Unit

    override fun isSuitable(data: Any) = typeClass.isInstance(data)

    class SimpleViewHolder(
        val binding: ViewBinding
    ) : RecyclerView.ViewHolder(binding.root)

}
