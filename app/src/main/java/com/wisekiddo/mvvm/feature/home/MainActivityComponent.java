package com.wisekiddo.mvvm.feature.home;

import com.wisekiddo.mvvm.base.di.ActivityScope;
import com.wisekiddo.mvvm.director.NavigatorModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScope
@Subcomponent(modules =  {MainScreenBindingModule.class, NavigatorModule.class})
public interface MainActivityComponent  extends AndroidInjector<MainActivity>{
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{
        @Override
        public void seedInstance(MainActivity instance) {

        }
    }
}
