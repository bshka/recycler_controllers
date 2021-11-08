package app.choco.livecode.ui.misc

import androidx.recyclerview.widget.RecyclerView

interface ControllersManager {

    fun getController(viewType: Int): Controller<Any, RecyclerView.ViewHolder>?

    fun getViewType(data: Any): Int?

    fun addController(controller: Controller<*, *>)

}
