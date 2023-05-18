package repo

import com.example.domain.model.Category
import com.example.domain.model.ItemModel
import com.example.domain.model.Jewelery
import com.example.domain.model.Product
import com.example.domain.repo.Repository
import com.example.domain.utils.ResultStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import service.ApiService
import java.io.IOException
import javax.inject.Inject

class RepositoryImpl @Inject constructor
    (private val api: ApiService) : Repository {
    override suspend fun getProducts(): Flow<ResultStatus<List<Product>>> = flow {
        try {
            emit(ResultStatus.Loading())
            val result = api.getProducts().products
            emit(ResultStatus.Success(result))
        } catch (e: IOException) {
            emit(ResultStatus.Error(e.message.toString()))
        } catch (e: Exception) {
            emit(ResultStatus.Error(e.message.toString()))
        }
    }

    override suspend fun getCategory(): Flow<ResultStatus<List<Category>>> = flow {
        try {
            emit(ResultStatus.Loading())
            val category = api.getCategory().category
            emit(ResultStatus.Success(category))
        } catch (e: IOException) {
            emit(ResultStatus.Error(e.message.toString()))
        } catch (e: Exception) {
            emit(ResultStatus.Error(e.message.toString()))
        }
    }
}