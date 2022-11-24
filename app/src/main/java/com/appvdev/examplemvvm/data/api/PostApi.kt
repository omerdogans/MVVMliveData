package com.appvdev.examplemvvm.data.api

import com.appvdev.examplemvvm.Model.Post
import io.reactivex.Single
import retrofit2.http.GET

interface PostApi {

    @GET("posts")
    fun getPosts(): Single<List<Post>>

}