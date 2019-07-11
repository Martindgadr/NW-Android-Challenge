package com.example.nw_android_challenge.commons.di.module

import com.example.nw_android_challenge.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [(FragmentModule::class)])
    abstract fun contributeMainActivity(): MainActivity
}