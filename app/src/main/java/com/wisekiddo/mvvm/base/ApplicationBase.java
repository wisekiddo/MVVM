package com.wisekiddo.mvvm.base;

import android.app.Application;

import com.wisekiddo.mvvm.base.di.ActivityInjector;

import javax.inject.Inject;

public class ApplicationBase extends Application{

    @Inject ActivityInjector activityInjector;
    private ApplicationComponent component;
    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        component.inject(this);
    }

    public ActivityInjector getActivityInjector(){
        return activityInjector;
    }
}
