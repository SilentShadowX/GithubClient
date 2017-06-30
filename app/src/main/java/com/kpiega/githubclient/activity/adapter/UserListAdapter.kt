package com.kpiega.githubclient.activity.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kpiega.githubclient.R
import com.kpiega.githubclient.data.model.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_user.view.*
import org.jetbrains.anko.sdk21.listeners.onClick

/**
 * Created by kpiega on 30.06.2017.
 */

class UserListAdapter(var userList: MutableList<User>, val listener: OnUserListDetailListener)
    : RecyclerView.Adapter<UserRowViewHolder>() {


    override fun onBindViewHolder(holder: UserRowViewHolder?, position: Int) {
            holder?.bind(userList.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): UserRowViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.row_user, parent, false)
        return UserRowViewHolder(view, listener)
    }

    override fun getItemCount(): Int = userList.size

    fun setList(list: MutableList<User>) {
        this.userList = list
        notifyDataSetChanged()
    }

}

class UserRowViewHolder(view: View, val listener: OnUserListDetailListener) : RecyclerView.ViewHolder(view) {

    fun bind(user: User) {
        Picasso.with(itemView.context).load(user.avatar).into(itemView.userImg)
        itemView.userLogin.text = user.login
        itemView.userDetailsBtn.onClick {
            listener.onClickDetailButton(user)
        }
    }

}

interface OnUserListDetailListener {
    fun onClickDetailButton(user: User)
}
