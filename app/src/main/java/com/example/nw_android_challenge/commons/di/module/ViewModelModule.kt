package com.example.nw_android_challenge.commons.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.nw_android_challenge.commons.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}