package service

import com.example.domain.model.Ratings
import model.ProductEntity
import model.Rating
import retrofit2.http.GET

interface ApiService {
    @GET("products/category/jewelery")
    suspend fun getImage(): List<ProductEntity>
}