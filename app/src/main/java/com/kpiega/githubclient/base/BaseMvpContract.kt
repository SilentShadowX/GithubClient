package com.kpiega.githubclient.base

/**
 * Created by kpiega on 30.06.2017.
 */

interface BaseMvpContract {

    interface BaseView {
        fun showLoading()
        fun hideLoading()
        fun showMessage(msg: String)
    }

    interface BasePresenter<V: BaseView> {
        var view: V?
        fun attachView(view: V)
        fun detachView()
    }
}
