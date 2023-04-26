package service

import model.ProductEntity
import retrofit2.http.GET

interface ApiService {
    @GET("products/category/jewelery")
    suspend fun getJewelery(): List<ProductEntity>
}