package com.kpiega.githubclient.activity.mvp

import com.kpiega.githubclient.data.manager.GitApi
import com.kpiega.githubclient.data.model.User
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by kpiega on 30.06.2017.
 */

class MainPresenterImpl
    @Inject constructor(val disposable: CompositeDisposable, val manager: GitApi)
        : MainPresenter {

    override var view: MainView? = null

    override fun getUserList() {
        disposable.add(
                manager.fetchUsers(object : DisposableSingleObserver<List<User>>() {

                    override fun onSuccess(t: List<User>?) {
                        Timber.d("List!")
                    }

                    override fun onError(e: Throwable?) {
                        Timber.d(e?.message)
                    }

                })
        )
    }

    override fun attachView(view: MainView) {
        this.view = view
    }

    override fun detachView() {
        disposable.dispose()
        this.view = null
    }

}