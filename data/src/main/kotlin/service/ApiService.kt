package service

import com.example.domain.model.Jewelery
import retrofit2.http.GET

interface ApiService {
    @GET("/products")
    suspend fun getProducts():Jewelery
    @GET("/category")
    suspend fun getCategory():Jewelery
}