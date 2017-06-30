package com.kpiega.githubclient.di.module

import com.kpiega.githubclient.data.manager.GitApi
import com.kpiega.githubclient.data.manager.GitManager
import com.kpiega.githubclient.di.scope.ActivityScope
import dagger.Binds
import dagger.Module

/**
 * Created by kpiega on 30.06.2017.
 */

@Module
abstract class ManagerModule {

    @Binds
    @ActivityScope
    abstract fun provideGitManager(manager: GitManager): GitApi

}