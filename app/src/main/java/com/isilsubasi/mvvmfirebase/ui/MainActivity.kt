package com.isilsubasi.mvvmfirebase.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.isilsubasi.mvvmfirebase.R

class MainActivity : AppCompatActivity() {

    var kategoriViewModel: KategoriViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kategorileriAl()
    }

    fun kategorileriAl(){

        kategoriViewModel= KategoriViewModel()
        kategoriViewModel?.apply {

            kategorilerLiveData?.observe(this@MainActivity, Observer {

                Log.e("Isil","Data : " + it.toString())
            })

            error?.observe(this@MainActivity, Observer {

                it.run {
                    Toast.makeText(applicationContext,this.localizedMessage, Toast.LENGTH_LONG).show()
                }
            })

            loading?.observe(this@MainActivity, Observer {

                //Handle loading
            })
        }

    }


}