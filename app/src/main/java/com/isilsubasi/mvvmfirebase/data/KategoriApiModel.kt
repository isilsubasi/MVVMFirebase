package com.isilsubasi.mvvmfirebase.data

data class KategoriApiModel(
    val Kategoriler:ArrayList<Kategoriler>
)
data class Kategoriler(
        val KategoriIsmi: String,
        val imageUrl: String
  )
