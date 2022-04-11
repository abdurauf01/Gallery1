package com.example.gallery.network

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://api.unsplash.com/search/photos?query=office&client_id=zfDB6i-fsjUVEuyUJYGe4sVaWKr29czUV1paO7Wsohw
class NetworkManager {
    companion object {
        private var retrofit: Retrofit? = null
        private var api: Api? = null
        fun getInstance(): Api {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("https://api.unsplash.com/")
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                api = retrofit!!.create(Api::class.java)
            }
            return api!!
        }
    }
}