package com.kpiega.githubclient.di.module

import android.app.Application
import android.content.Context
import com.kpiega.githubclient.GitApp
import com.kpiega.githubclient.di.qualifier.ApplicationContext
import com.kpiega.githubclient.di.scope.ApplicationScope
import dagger.Binds
import dagger.Module

/**
 * Created by kpiega on 30.06.2017.
 */

@Module
abstract class AppModule {

    @Binds
    @ApplicationScope
    abstract fun provideApplication(app: GitApp): Application

    @Binds
    @ApplicationContext
    @ApplicationScope
    abstract fun provideContext(app: GitApp): Context

}