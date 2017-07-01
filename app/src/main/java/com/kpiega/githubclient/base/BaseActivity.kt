package com.kpiega.githubclient.base

import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.toast

/**
 * Created by kpiega on 30.06.2017.
 */

open class BaseActivity: DaggerAppCompatActivity(), BaseMvpContract.BaseView {

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showMessage(msg: String) = with(msg) {
        toast(msg)
    }


}