package com.example.nw_android_challenge.commons.di

import com.example.nw_android_challenge.NWApplication
import com.example.nw_android_challenge.commons.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule::class), (AndroidInjectionModule::class),
    (ActivityModule::class), (FragmentModule::class), (ViewModelModule::class), (RepositoryModule::class)])
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: NWApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: NWApplication)
}