package com.kpiega.githubclient.activity.mvp

import com.kpiega.githubclient.base.BaseMvpContract
import com.kpiega.githubclient.data.model.User
import com.kpiega.githubclient.data.model.UserDetails

/**
 * Created by kpiega on 30.06.2017.
 */

interface MainView: BaseMvpContract.BaseView {

    fun putUserList(list: MutableList<User>)
    fun showDetailsDialog(details: UserDetails)
}