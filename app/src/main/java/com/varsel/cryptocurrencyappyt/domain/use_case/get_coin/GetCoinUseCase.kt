package com.varsel.cryptocurrencyappyt.domain.use_case.get_coin

import com.varsel.cryptocurrencyappyt.common.Resource
import com.varsel.cryptocurrencyappyt.data.remote.dto.toCoin
import com.varsel.cryptocurrencyappyt.data.remote.dto.toCoinDetail
import com.varsel.cryptocurrencyappyt.domain.model.Coin
import com.varsel.cryptocurrencyappyt.domain.model.CoinDetail
import com.varsel.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCounById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't connect to server, check your internet"))
        }
    }
}