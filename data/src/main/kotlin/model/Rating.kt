package model

data class Rating<T>(
    val hits: List<T>,
    val count: Int,
    val rate: Double
)