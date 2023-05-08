package service

import dto.MainResponceItem
import dto.MainResponse
import retrofit2.http.GET

interface ApiService {
    @GET("/")
    suspend fun getJewelery(): MainResponse<MainResponceItem>
}