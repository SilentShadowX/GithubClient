package com.kpiega.githubclient.di.module

import com.kpiega.githubclient.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Qualifier

@Module
class RxModule {

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()

    @Provides
    @RxUI
    @ApplicationScope
    fun provideMainThread() = AndroidSchedulers.mainThread()

    @Provides
    @RxComputation
    @ApplicationScope
    fun provideCompitationThread() = Schedulers.computation()

    @Provides
    @RxIO
    @ApplicationScope
    fun provideIoThread() = Schedulers.io()

    @Provides
    @RxTrampoline
    @ApplicationScope
    fun provideTrampolineThread() = Schedulers.trampoline()

    @Provides
    @RxNewThread
    @ApplicationScope
    fun provideNewThread() = Schedulers.newThread()
}


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RxNewThread

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RxTrampoline

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RxIO

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RxComputation

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RxUI
