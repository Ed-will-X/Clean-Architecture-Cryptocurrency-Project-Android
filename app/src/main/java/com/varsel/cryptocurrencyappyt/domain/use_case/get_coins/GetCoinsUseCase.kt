package com.varsel.cryptocurrencyappyt.domain.use_case.get_coins

import com.varsel.cryptocurrencyappyt.common.Resource
import com.varsel.cryptocurrencyappyt.data.remote.dto.toCoin
import com.varsel.cryptocurrencyappyt.domain.model.Coin
import com.varsel.cryptocurrencyappyt.domain.model.CoinDetail
import com.varsel.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't connect to server, check your internet"))
        }
    }
}