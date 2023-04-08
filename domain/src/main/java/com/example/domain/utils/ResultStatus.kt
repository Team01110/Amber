package com.example.domain.utils

sealed class ResultStatus<T>(
    val data: T? = null,
    val error: String = "Unknown error!"
) {
    class Loading<T> : ResultStatus<T>()
    class Success<T>(data: T?) : ResultStatus<T>(data = data)
    class Error<T>(message: String) : ResultStatus<T>(error = message)

}
