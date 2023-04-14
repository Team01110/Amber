package base

import com.example.domain.utils.ResultStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import model.AmberEntity
import model.Rating
import retrofit2.HttpException
import service.ApiService
import java.io.IOException

fun <T> doRequest(request: suspend ()-> T)= flow {
        try {
            emit(ResultStatus.Loading())
            val data = request()
            emit(ResultStatus.Success(data))
        } catch (e: IOException) {
            emit(ResultStatus.Error(msg = "$e"))
        } catch (e: HttpException) {
            emit(ResultStatus.Error(msg = "$e"))
        }
    }.flowOn(Dispatchers.IO)
