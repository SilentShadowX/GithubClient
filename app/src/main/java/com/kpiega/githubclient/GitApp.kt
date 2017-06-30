package com.kpiega.githubclient

//import com.kpiega.githubclient.di.DaggerAppComponent
import com.kpiega.githubclient.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by kpiega on 30.06.2017.
 */

class GitApp: DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
            DaggerAppComponent.builder().create(this)

}
