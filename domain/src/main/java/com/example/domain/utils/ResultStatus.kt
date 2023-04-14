package com.example.domain.utils

sealed class ResultStatus<T>(
    val data: T? = null,
    val error: String? = null
) {
    class Loading<T> : ResultStatus<T>()
    class Success<T>(data: T?) : ResultStatus<T>(data = data)
    class Error<T>(msg: String) : ResultStatus<T>(error = msg)

}
