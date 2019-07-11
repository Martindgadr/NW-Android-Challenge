package com.example.nw_android_challenge.commons.di.module

import com.example.nw_android_challenge.commons.di.anotations.FragmentScope
import com.example.nw_android_challenge.ui.mainpost.PostFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    @FragmentScope
    abstract fun contributePostFragment(): PostFragment
}