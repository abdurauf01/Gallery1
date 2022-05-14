package com.example.gallery.network

import com.example.gallery.models.AllPhotos
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

//https://api.unsplash.com/search/photos?query=office&client_id=zfDB6i-fsjUVEuyUJYGe4sVaWKr29czUV1paO7Wsohw
interface Api {

    @GET("/search/photos?per_page=50&query=&client_id=zfDB6i-fsjUVEuyUJYGe4sVaWKr29czUV1paO7Wsohw")
    fun getPhotos(@Query("query") technology: String): Observable<AllPhotos>

}