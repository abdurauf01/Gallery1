package com.example.gallery.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.gallery.models.AllPhotos
import com.example.gallery.models.Resultt
import com.example.gallery.network.NetworkManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class Repository {

    private val compositeDisposable = CompositeDisposable()

    fun getPhotoFromApi(
        errors: MutableLiveData<String>,
        res: MutableLiveData<List<Resultt>>,
        query: String
    ) {
        compositeDisposable.add(
            NetworkManager.getInstance().getPhotos(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<AllPhotos>() {
                    override fun onNext(t: AllPhotos) {
                        res.value = t.results
                    }

                    override fun onError(e: Throwable) {
                        errors.value = e.localizedMessage
                    }

                    override fun onComplete() {

                    }

                })
        )
    }

    fun getPhotosFromApi(
        errors: MutableLiveData<String>,
        res: MutableLiveData<List<Resultt>>,
        query:Map<String,String>
    ) {
        compositeDisposable.add(
            NetworkManager.getInstance().getAllPhotos(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<AllPhotos>() {
                    override fun onNext(t: AllPhotos) {
                        res.value = t.results
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
