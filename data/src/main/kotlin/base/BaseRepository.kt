package base

import com.example.domain.utils.ResultStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
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
    }.flowOn(Dispatchers.IO).catch {exception ->
        emit(ResultStatus.Error(msg = exception.localizedMessage ?: "Error Occurred!"))
}
