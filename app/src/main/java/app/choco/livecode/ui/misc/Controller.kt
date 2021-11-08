package app.choco.livecode.ui.misc

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class Controller<T : Any, H : RecyclerView.ViewHolder> {

    abstract fun createViewHolder(parent: ViewGroup): H

    abstract fun bindViewHolder(data: T, holder: H)

    open fun bindViewHolder(data: T, holder: H, payloads: List<Any>) {
        bindViewHolder(data, holder)
    }

    abstract fun onViewRecycled(holder: H)

    abstract fun isSuitable(data: Any): Boolean

}
