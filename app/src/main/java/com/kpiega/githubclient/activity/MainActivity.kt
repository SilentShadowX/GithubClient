package com.kpiega.githubclient.activity

import android.os.Bundle
import com.kpiega.githubclient.R
import com.kpiega.githubclient.activity.adapter.UserListAdapter
import com.kpiega.githubclient.activity.mvp.MainPresenter
import com.kpiega.githubclient.activity.mvp.MainView
import com.kpiega.githubclient.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    lateinit var adapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.getUserList()
    }






}
