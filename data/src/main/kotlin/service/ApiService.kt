package service

import model.AmberEntity
import model.Rating
import retrofit2.http.GET

interface ApiService {
    @GET("products/category/jewelery")
    suspend fun getImage():Rating<AmberEntity>
}