package com.kpiega.githubclient.di

import com.kpiega.githubclient.GitApp
import com.kpiega.githubclient.di.module.ActivityBindingModule
import com.kpiega.githubclient.di.module.GitModule
import com.kpiega.githubclient.di.module.InfoModule
import com.kpiega.githubclient.di.module.RxModule
import com.kpiega.githubclient.di.scope.ApplicationScope
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by kpiega on 30.06.2017.
 */

@ApplicationScope
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        GitModule::class,
        RxModule::class,
        InfoModule::class
))
interface AppComponent : AndroidInjector<GitApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<GitApp>()

}