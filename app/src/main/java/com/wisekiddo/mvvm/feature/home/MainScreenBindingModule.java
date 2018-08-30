package com.wisekiddo.mvvm.feature.home;

import com.bluelinelabs.conductor.Controller;
import com.wisekiddo.mvvm.feature.trending.TrendingReposComponent;
import com.wisekiddo.mvvm.feature.trending.TrendingReposController;
import com.wisekiddo.mvvm.base.di.ControllerKey;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {TrendingReposComponent.class,})
public abstract class MainScreenBindingModule {
    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);

}
