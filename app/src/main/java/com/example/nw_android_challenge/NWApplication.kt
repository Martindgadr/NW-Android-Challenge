package com.example.nw_android_challenge

import android.app.Activity
import android.app.Application
import com.example.nw_android_challenge.commons.di.ApplicationComponent
import com.example.nw_android_challenge.commons.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class NWApplication: Application(), HasActivityInjector {
    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().application(this).build()
        applicationComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}