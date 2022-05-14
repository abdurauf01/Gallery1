package com.example.gallery.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.gallery.models.AllPhotos
import com.example.gallery.models.Resultt
import com.example.gallery.network.Api
import com.example.gallery.network.NetworkManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private val compositeDisposable = CompositeDisposable()
//    private lateinit var api: Api
    fun getPhotoFromApi(
        errors: MutableLiveData<String>,
        res: MutableLiveData<AllPhotos>,
        query: String
    ) {

      /*  api = NetworkManager.getInstance()
        api.getPhotos(query).enqueue(object : Callback<AllPhotos> {
            override fun onResponse(call: Call<AllPhotos>, response: Response<AllPhotos>) {
                res.value = response.body()
            }

            override fun onFailure(call: Call<AllPhotos>, t: Throwable) {
                errors.value = t.localizedMessage
            }
        })*/


        compositeDisposable.add(
            NetworkManager.getInstance().getPhotos(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<AllPhotos>() {
                    override fun onNext(t: AllPhotos) {
                        res.value = t
                    }

                    override fun onError(e: Throwable) {
                        errors.value = e.localizedMessage
                    }

                    override fun onComplete() {

                    }

                })
        )
    }

}
