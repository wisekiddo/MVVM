package com.wisekiddo.mvvm.feature.home;

import com.bluelinelabs.conductor.Controller;
import com.wisekiddo.mvvm.data.TrendingReposComponent;
import com.wisekiddo.mvvm.data.TrendingReposController;
import com.wisekiddo.mvvm.di.ControllerKey;

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
