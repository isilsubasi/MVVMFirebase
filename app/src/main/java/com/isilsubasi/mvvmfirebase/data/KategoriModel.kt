package com.isilsubasi.mvvmfirebase.data

import androidx.annotation.Keep
import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.PropertyName
import com.google.gson.annotations.SerializedName

@Keep
@IgnoreExtraProperties
class KategoriItem {
    @PropertyName("kategoriIsmi")
    @SerializedName("kategoriIsmi")
    val kategoriIsmi: String? = null

    @PropertyName("imageUrl")
    @SerializedName("imageUrl")
    val imageUrl: String? = null
    override fun toString(): String {
        return "KategoriItem(kategoriIsmi=$kategoriIsmi, imageUrl=$imageUrl)"
    }


}