package com.kpiega.githubclient.di.module

import com.kpiega.githubclient.activity.MainActivity
import com.kpiega.githubclient.activity.MainModule
import com.kpiega.githubclient.di.scope.ActivityScope
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.ContributesAndroidInjector

/**
 * Created by kpiega on 30.06.2017.
 */

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(
            MainModule::class, ManagerModule::class
    ))
    abstract fun provideMain(): MainActivity
}