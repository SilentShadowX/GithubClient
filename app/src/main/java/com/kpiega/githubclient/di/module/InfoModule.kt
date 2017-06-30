package com.kpiega.githubclient.di.module

import com.kpiega.githubclient.di.qualifier.ApiUrl
import dagger.Module
import dagger.Provides

/**
 * Created by kpiega on 30.06.2017.
 */

@Module
class InfoModule {

    @Provides
    @ApiUrl
    fun provideUrl() = "https://api.github.com/"

}