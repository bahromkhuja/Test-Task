package com.example.testtask.domain

import com.example.testtask.domain.repository.GetDataRepository
import com.example.testtask.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetDataUseCase @Inject constructor(private val repository: GetDataRepository) {

    operator fun invoke(): Flow<Resource<DataResponse>> =
        flow{
            try {
                emit(Resource.Loading<DataResponse>())
                val response: DataResponse = repository.getData()
                emit(Resource.Success<DataResponse>(response))
            }catch (e: HttpException) {
                emit(
                    Resource.Error<DataResponse>(
                        e.localizedMessage ?: "Произошла непредвиденная ошибка"
                    )
                )
            } catch (e: IOException) {
                emit(Resource.Error<DataResponse>("Не удалось связаться с сервером. Проверьте подключение к Интернету."))
            } catch (e: Exception) {
                emit(Resource.Error<DataResponse>("${e.message}"))
            }
        }
}