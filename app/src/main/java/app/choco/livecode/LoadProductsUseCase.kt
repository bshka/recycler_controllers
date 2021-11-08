package app.choco.livecode

import app.choco.livecode.data.ProductDto
import app.choco.livecode.data.ProductService

interface LoadProductsUseCase {

    suspend fun load(): List<ProductDto>

}

class DefaultLoadProductsUseCase(
    private val productService: ProductService
) : LoadProductsUseCase {
    override suspend fun load() = productService.getProducts()
}
