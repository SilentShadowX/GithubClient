package com.kpiega.githubclient.di.module

import com.kpiega.githubclient.data.service.GithubService
import com.kpiega.githubclient.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by kpiega on 30.06.2017.
 */

@Module(includes = arrayOf(
        NetworkModule::class
))
class GitModule {

    @Provides
    @ApplicationScope
    fun provideGitService(retrofit: Retrofit) =
            retrofit.create(GithubService::class.java)
}