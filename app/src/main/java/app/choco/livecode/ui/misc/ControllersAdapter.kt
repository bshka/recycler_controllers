package app.choco.livecode.ui.misc

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ControllersAdapter<T : Any>(
    private val manager: ControllersManager
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<T> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private fun getItem(position: Int) = items[position]

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        manager.getController(viewType)?.createViewHolder(parent) ?: throw ControllersAdapterException()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        manager.getController(holder.itemViewType)?.bindViewHolder(getItem(position), holder)
            ?: throw ControllersAdapterException()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, payloads: List<Any>) =
        manager.getController(holder.itemViewType)?.bindViewHolder(getItem(position), holder, payloads)
            ?: throw ControllersAdapterException()

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        manager.getController(holder.itemViewType)?.onViewRecycled(holder)
            ?: throw ControllersAdapterException()
    }

    override fun getItemViewType(position: Int) = manager.getViewType(getItem(position))
        ?: throw ControllersAdapterException()

}

class ControllersAdapterException : IllegalStateException("Setup controller")
