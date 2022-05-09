package com.isilsubasi.mvvmfirebase.data

import com.isilsubasi.mvvmfirebase.util.Resource
import kotlinx.coroutines.flow.Flow

class KategoriRepository {

    private var kategoriDataSource: KategoriDataSource?=null

    init {
        //Burda artık hangisinden diye soruyor bize?
        kategoriDataSource=KategoriFirebaseDataSource()
    }

    fun kategorileriGetir(): Flow<Resource<List<KategoriItem>>>
    {
        return kategoriDataSource!!.kategorileriGetir()
    }



}