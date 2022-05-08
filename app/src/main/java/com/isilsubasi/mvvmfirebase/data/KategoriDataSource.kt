package com.isilsubasi.mvvmfirebase.data

import com.isilsubasi.mvvmfirebase.util.Resource
import kotlinx.coroutines.flow.Flow

interface KategoriDataSource {
    fun kategorileriGetir(): Flow<Resource<Kategoriler>>

}