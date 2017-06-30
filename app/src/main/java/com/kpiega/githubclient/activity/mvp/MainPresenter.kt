package com.kpiega.githubclient.activity.mvp

import com.kpiega.githubclient.base.BaseMvpContract

/**
 * Created by kpiega on 30.06.2017.
 */

interface MainPresenter : BaseMvpContract.BasePresenter<MainView> {

    fun getUserList()
    fun loadUserByLogin(login: String)
}