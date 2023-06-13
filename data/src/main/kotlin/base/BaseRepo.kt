package base

import com.example.domain.utils.ResultStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

abstract class BaseRepo {
    protected fun <T> doRequest(request: suspend () -> T) = flow {
        emit(ResultStatus.Loading())
        try {
            val data = request()
            emit(ResultStatus.Success(data))
        } catch (e: IOException) {
            emit(e.message?.let { ResultStatus.Error(it) })
        }
    }.flowOn(Dispatchers.IO)
}