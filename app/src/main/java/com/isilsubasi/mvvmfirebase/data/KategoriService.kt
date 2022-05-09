package com.isilsubasi.mvvmfirebase.data

import com.isilsubasi.mvvmfirebase.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface KategoriService {

    //https://raw.githubusercontent.com/isilsubasi/MVVMFirebase/main/arabalar.json
    @GET("arabalar.json")
    suspend fun kategorileriGetir(): Response<List<KategoriItem>>

    companion object  {

        fun build(): KategoriService {

            //Loglarda
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val okHtppClient =  OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            //retrofiti kurarken okHttpi kurup set ettim.
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .client(okHtppClient)
                .build() // Bu servisle istediğim isteği atabileceğim

            return retrofit.create(KategoriService::class.java)
        }
    }



}
