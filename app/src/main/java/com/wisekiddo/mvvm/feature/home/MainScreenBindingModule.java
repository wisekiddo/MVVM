package com.wisekiddo.mvvm.feature.home;

import com.bluelinelabs.conductor.Controller;
import com.wisekiddo.mvvm.feature.trending.TrendingComponent;
import com.wisekiddo.mvvm.feature.trending.TrendingController;
import com.wisekiddo.mvvm.base.di.ControllerKey;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        TrendingComponent.class,
})

public abstract class MainScreenBindingModule {
    @Binds
    @IntoMap
    @ControllerKey(TrendingController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingComponent.Builder builder);

}
