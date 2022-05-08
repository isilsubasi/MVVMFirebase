package com.isilsubasi.mvvmfirebase.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.isilsubasi.mvvmfirebase.data.KategoriRepository
import com.isilsubasi.mvvmfirebase.data.Kategoriler
import com.isilsubasi.mvvmfirebase.util.ResourceStatus
import kotlinx.coroutines.launch

class KategoriViewModel : ViewModel(){

    private  val kategoriRepository: KategoriRepository = KategoriRepository()

    init {
        kategorileriGetir()
    }

    var kategorilerLiveData: MutableLiveData<Kategoriler>? = null
    var error :    MutableLiveData<Throwable>? = null
    var loading :    MutableLiveData<Boolean>? = null

    fun kategorileriGetir()  = viewModelScope.launch {

        kategoriRepository.kategorileriGetir()

            .asLiveData(viewModelScope.coroutineContext).observeForever {

                when(it.status) {
                    ResourceStatus.LOADING -> {
                        loading?.postValue(true)
                    }

                    ResourceStatus.SUCCESS -> {
                        kategorilerLiveData?.postValue(it.data)
                        loading?.postValue(false)
                    }
                    ResourceStatus.ERROR -> {
                        Log.e("ERROR", "${it.throwable}")
                        error?.postValue(it.throwable!!)
                        loading?.postValue(false)
                    }
                }
            }
    }

}