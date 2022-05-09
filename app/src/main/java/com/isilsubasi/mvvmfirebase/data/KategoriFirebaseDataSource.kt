package com.isilsubasi.mvvmfirebase.data

import android.util.Log
import com.google.firebase.database.*
import com.isilsubasi.mvvmfirebase.util.Resource
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class KategoriFirebaseDataSource : KategoriDataSource{

    override fun kategorileriGetir() : Flow<Resource<List<KategoriItem>>> = callbackFlow {

        try {
            offer(Resource.Loading())

            val database: DatabaseReference = FirebaseDatabase.getInstance().getReference()
            val myRef: DatabaseReference = database.child("/")

            var kategoriListesi = arrayListOf<KategoriItem>()



            val subscription = myRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (postSnapshoot in snapshot.getChildren()) {

                        Log.e("Isil","postSnapshoot : " + postSnapshoot)

                        var item = postSnapshoot.getValue(KategoriItem::class.java)!!
                        Log.e("Isil","item : " + item.toString())


                        kategoriListesi.add(item)
                    }

                    offer(Resource.Success(kategoriListesi))
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }


            })

            awaitClose{}

        }catch (e : Exception){
            offer(Resource.Error(e))
            e.printStackTrace()
        }



    }

}