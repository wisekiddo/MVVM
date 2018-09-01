package com.wisekiddo.mvvm.base;

import android.app.Application;

import com.wisekiddo.mvvm.BuildConfig;
import com.wisekiddo.mvvm.base.di.ActivityInjector;

import javax.inject.Inject;

import timber.log.Timber;

public class ApplicationBase extends Application{

    @Inject ActivityInjector activityInjector;

    protected ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = initComponent();
        component.inject(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    protected ApplicationComponent initComponent(){
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

    }
    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}
