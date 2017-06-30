package com.kpiega.githubclient.data.manager

import com.kpiega.githubclient.data.model.User
import com.kpiega.githubclient.data.model.UserDetails
import com.kpiega.githubclient.data.service.GithubService
import com.kpiega.githubclient.di.module.RxIO
import com.kpiega.githubclient.di.module.RxUI
import com.kpiega.githubclient.di.scope.ActivityScope
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

/**
 * Created by kpiega on 30.06.2017.
 */

@ActivityScope
class GitManager
    @Inject constructor( var service: GithubService, @RxIO val work: Scheduler, @RxUI val main: Scheduler) : GitApi {

    override fun fetchUsers(observ: DisposableSingleObserver<List<User>>): Disposable =
            service.fetchUsers()
                    .subscribeOn(work)
                    .observeOn(main)
                    .subscribeWith(observ)

    override fun fetchUserDetails(login: String, observ: DisposableSingleObserver<UserDetails>): Disposable =
            service.fetchUserDetails(login)
                    .subscribeOn(work)
                    .observeOn(main)
                    .subscribeWith(observ)
}

