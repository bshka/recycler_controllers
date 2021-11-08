package app.choco.livecode.di

import app.choco.livecode.DefaultLoadProductsUseCase
import app.choco.livecode.LoadProductsUseCase
import app.choco.livecode.data.ProductService
import app.choco.livecode.ui.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val serviceModule = module {
    single { ProductService.create() }
    single<LoadProductsUseCase> {
        DefaultLoadProductsUseCase(get())
    }
}

val viewModelModule = module {

    viewModel { MainActivityViewModel(get()) }

}
