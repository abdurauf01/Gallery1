package com.example.gallery.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gallery.models.AllPhotos
import com.example.gallery.models.Resultt
import com.example.gallery.ui.fragments.All

class MainViewModel : ViewModel() {
    val error = MutableLiveData<String>()
    val res = MutableLiveData<AllPhotos>()
    val allPhotos = MutableLiveData<AllPhotos>()



    fun getPhotoFromRep(query: String) {
        Repository().getPhotoFromApi(error, res, query)
    }

    fun getPhotosFromRepp(allPhotos: AllPhotos) {
         this.allPhotos.value = allPhotos
    }


}