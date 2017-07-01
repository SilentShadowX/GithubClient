package com.kpiega.githubclient.activity.mvp

import com.kpiega.githubclient.data.manager.GitApi
import com.kpiega.githubclient.data.model.User
import com.kpiega.githubclient.data.model.UserDetails
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import timber.log.Timber
import java.net.UnknownHostException
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
                        t?.let {
                            view?.putUserList(t as MutableList<User>)
                        }

                    }

                    override fun onError(e: Throwable?) {
                        when (e) {
                            is UnknownHostException -> {
                                view?.showMessage("Check internet connection!")

                            }
                            else -> Timber.d(e?.message)
                        }
                    }

                })
        )
    }

    override fun loadUserByLogin(login: String) {

        disposable.add(
                manager.fetchUserDetails(login, object : DisposableSingleObserver<UserDetails>() {

                    override fun onSuccess(t: UserDetails?) {
                        t?.let {
                            view?.showDetailsDialog(t)
                        }
                    }

                    override fun onError(e: Throwable?) {
                        when (e) {
                            is UnknownHostException -> {
                                view?.showMessage("Check internet connection!")
                            }
                            else -> Timber.d(e?.message)
                        }
                    }

                })
        )
    }

    override fun attachView(view: MainView) {
        this.view = view
    }

    override fun detachView() {
        disposable.clear()
        this.view = null
    }

}