package repo

import com.example.domain.model.AmberItem
import com.example.domain.repo.Repository
import com.example.domain.utils.ResultStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import service.ApiService
import java.io.IOException
import javax.inject.Inject

class RepositoryImpl @Inject constructor
    (private val api: ApiService) : Repository {
    override fun getAllAmber(): Flow<ResultStatus<List<AmberItem>>> = flow {
        try {
            emit(ResultStatus.Loading())
            val result = api.getImage()
            emit(ResultStatus.Success(result.hits.map { it.toDomain() }))
        } catch (e: IOException) {
            emit(ResultStatus.Error(msg = "$e"))
        } catch (e: HttpException) {
            emit(ResultStatus.Error(msg = "$e"))
        }
    }
}