package repo

import base.doRequest
import com.example.domain.model.Jewelery
import com.example.domain.repo.Repository
import com.example.domain.utils.ResultStatus
import kotlinx.coroutines.flow.Flow
import service.ApiService
import javax.inject.Inject

class RepositoryImpl @Inject constructor
    (private val api: ApiService) : Repository {
    override fun getAllAmber(): Flow<ResultStatus<List<Jewelery>>> = doRequest {
        api.getImage().map { it.toDomain() }
    }

    override fun getRecommenAmber(): Flow<ResultStatus<List<Jewelery>>> = doRequest {
        api.getImage().map { it.toDomain() }
    }
}