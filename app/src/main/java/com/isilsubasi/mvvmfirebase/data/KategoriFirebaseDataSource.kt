package com.isilsubasi.mvvmfirebase.data

import com.isilsubasi.mvvmfirebase.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class KategoriFirebaseDataSource : KategoriDataSource{
    override fun kategorileriGetir(): Flow<Resource<Kategoriler>> = flow{
        try {
            emit(Resource.Loading())

            val response = KategoriService.build().kategorileriGetir()

            if (response.isSuccessful) {

                response.body()?.let {
                    emit(Resource.Success(it))
                }
            }

        } catch (e: Exception) {
            emit(Resource.Error(e))
            e.printStackTrace()
        }
    }
}