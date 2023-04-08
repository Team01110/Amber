package service

import retrofit2.http.GET

interface ApiService {
    @GET("products/category/jewelery")
    suspend fun getImage()
}