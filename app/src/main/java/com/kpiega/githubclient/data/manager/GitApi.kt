package com.kpiega.githubclient.data.manager

import com.kpiega.githubclient.data.model.User
import com.kpiega.githubclient.data.model.UserDetails
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver

interface GitApi {
    fun fetchUsers(observ: DisposableSingleObserver<List<User>>): Disposable
    fun fetchUserDetails(login: String, observ: DisposableSingleObserver<UserDetails>): Disposable
}