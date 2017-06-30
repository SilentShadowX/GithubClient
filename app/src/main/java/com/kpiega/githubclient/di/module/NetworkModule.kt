package com.kpiega.githubclient.di.module

import android.content.Context
import com.google.gson.Gson
import com.kpiega.githubclient.di.qualifier.ApiUrl
import com.kpiega.githubclient.di.qualifier.ApplicationContext
import com.kpiega.githubclient.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

/**
 * Created by kpiega on 30.06.2017.
 */

@Module(includes = arrayOf(
        AppModule::class
))
class NetworkModule {

    @Provides
    @ApplicationScope
    fun provideCacheFile(@ApplicationContext context: Context): File {
        val cacheFile = File(context.cacheDir, "http_cache")
        cacheFile.mkdir()
        return cacheFile
    }

    @Provides
    @ApplicationScope
    fun provideCache(file: File) = Cache(file, 10 * 1024 * 1024)

    @Provides
    @ApplicationScope
    fun provideInterceptorHttp() = HttpLoggingInterceptor()

    @Provides
    @ApplicationScope
    fun provideGson() = Gson()

    @Provides
    @ApplicationScope
    fun provideHttpClient(
            logger: HttpLoggingInterceptor,
            cache: Cache
    ) = OkHttpClient.Builder()
            .addInterceptor(logger)
            .cache(cache)
            .build()

    @Provides
    @ApplicationScope
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson, @ApiUrl url: String) = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()


}