package app.choco.livecode.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import app.choco.livecode.databinding.ActivityMainBinding
import app.choco.livecode.ui.misc.ControllersAdapter
import app.choco.livecode.ui.misc.DefaultControllersManager
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val vm: MainActivityViewModel by viewModel()

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapter by lazy {
        ControllersAdapter<Any>(
            manager = DefaultControllersManager().apply {
                addController(ProductItemController(vm::onButtonClicked))
                addController(ImageItemController())
                addController(StringItemController())
                addController(StubController())
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecycler()
        vm.listItemsLiveData.observe(this) {
            adapter.items = it
        }
    }

    private fun initRecycler() = with(binding.recyclerView) {
        layoutManager = LinearLayoutManager(this@MainActivity)
        adapter = this@MainActivity.adapter
    }

}
