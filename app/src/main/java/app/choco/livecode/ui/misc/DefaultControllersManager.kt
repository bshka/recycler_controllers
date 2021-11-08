package app.choco.livecode.ui.misc

import androidx.recyclerview.widget.RecyclerView

class DefaultControllersManager : ControllersManager {

    private val controllers = LinkedHashMap<Int, Controller<*, *>>()

    override fun getController(viewType: Int): Controller<Any, RecyclerView.ViewHolder>? =
        controllers[viewType] as Controller<Any, RecyclerView.ViewHolder>?

    override fun getViewType(data: Any): Int? {
        for ((viewType, controller) in controllers) {
            if (controller.isSuitable(data)) {
                return viewType
            }
        }
        return null
    }

    override fun addController(controller: Controller<*, *>) {
        controllers[controllers.size] = controller
    }

}
