package com.kpiega.githubclient.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.kpiega.githubclient.R
import com.kpiega.githubclient.activity.adapter.OnUserListDetailListener
import com.kpiega.githubclient.activity.adapter.UserListAdapter
import com.kpiega.githubclient.activity.mvp.MainPresenter
import com.kpiega.githubclient.activity.mvp.MainView
import com.kpiega.githubclient.base.BaseActivity
import com.kpiega.githubclient.data.model.User
import com.kpiega.githubclient.data.model.UserDetails
import com.kpiega.githubclient.dialog.UserDetailsDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    var layoutManager = LinearLayoutManager(this)

    lateinit var adapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
        initRequest()
    }

    override fun onStop() {
        presenter.detachView()
        super.onStop()
    }

    private fun initRequest() {
        presenter.getUserList()
    }

    private fun initRecycler() {
        adapter = UserListAdapter(Collections.emptyList(), clickUserListner)
        userList.layoutManager = layoutManager
        userList.adapter = adapter
    }

    override fun putUserList(list: MutableList<User>) {
        adapter.setList(list)
    }

    val clickUserListner = object: OnUserListDetailListener {
        override fun onClickDetailButton(user: User) {
            presenter.loadUserByLogin(user.login)
        }
    }

    override fun showDetailsDialog(details: UserDetails) {
        UserDetailsDialog.showDialog(details, fragmentManager)
    }

}
