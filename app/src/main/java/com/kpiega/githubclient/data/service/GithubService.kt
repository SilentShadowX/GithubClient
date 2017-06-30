package com.kpiega.githubclient.data.service

import com.kpiega.githubclient.data.model.UserDetails
import com.kpiega.githubclient.data.model.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by kpiega on 30.06.2017.
 */

interface GithubService {

    @GET("users/")
    fun fetchUsers(): Single<List<User>>
    @GET("users/{login}")
    fun fetchUserDetails(@Path("login") login: String): Single<UserDetails>
}

