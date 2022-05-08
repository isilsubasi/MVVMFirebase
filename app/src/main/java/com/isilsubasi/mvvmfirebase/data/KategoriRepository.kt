package com.isilsubasi.mvvmfirebase.data

import com.isilsubasi.mvvmfirebase.util.Resource
import kotlinx.coroutines.flow.Flow

class KategoriRepository {

    private var kategoriDataSource: KategoriDataSource?=null

    init {
        //Burda artık hangisinden diye soruyor bize?
        kategoriDataSource=KategoriRetrofitDataSource()
    }

    fun kategorileriGetir(): Flow<Resource<Kategoriler>>
    {
        return kategoriDataSource!!.kategorileriGetir()
    }



}