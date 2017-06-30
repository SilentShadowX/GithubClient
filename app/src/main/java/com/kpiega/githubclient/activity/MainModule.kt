package com.kpiega.githubclient.activity

import com.kpiega.githubclient.activity.mvp.MainPresenter
import com.kpiega.githubclient.activity.mvp.MainPresenterImpl
import com.kpiega.githubclient.di.module.ManagerModule
import com.kpiega.githubclient.di.scope.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by kpiega on 30.06.2017.
 */

@Module(includes = arrayOf(
        ManagerModule::class
))
abstract class MainModule {

    @Binds
    @ActivityScope
    abstract fun providePresenter(presenter: MainPresenterImpl): MainPresenter

//    @Module
//    companion object {
//        @Provides
//        @ActivityScope
//        fun provideDisposable() = CompositeDisposable()
//    }
}