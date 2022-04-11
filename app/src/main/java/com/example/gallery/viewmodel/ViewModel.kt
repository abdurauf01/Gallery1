package com.example.gallery.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gallery.models.Resultt

class MainViewModel : ViewModel() {
    val error = MutableLiveData<String>()
    val res = MutableLiveData<List<Resultt>>()

    fun getPhotoFromRep(query: String) {
        Repository().getPhotoFromApi(error, res, query)
    }

    fun getPhotosFromRep(query: Map<String, String>) {
        Repository().getPhotosFromApi(error, res, query)
    }
}