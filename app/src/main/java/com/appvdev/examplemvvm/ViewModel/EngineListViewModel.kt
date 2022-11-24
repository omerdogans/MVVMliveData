package com.appvdev.examplemvvm.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appvdev.examplemvvm.Model.Post
import com.appvdev.examplemvvm.data.api.PostService
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class EngineListViewModel: ViewModel() {

    val posts = MutableLiveData<List<Post>>()

    private val  postService : PostService = PostService()
    private val disposable: CompositeDisposable = CompositeDisposable()

    fun refresh(){
        fetchDataFromRemoteApi()
    }

    fun fetchDataFromRemoteApi() {
     disposable.add(
         postService.getPosts()
             .subscribeOn(Schedulers.newThread())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribeWith(object : DisposableSingleObserver<List<Post>>(){
                 override fun onSuccess(postList: List<Post>) {
                     posts.value = postList
                 }

                 override fun onError(e: Throwable) {
                     e.printStackTrace()
                 }

             })
     )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}