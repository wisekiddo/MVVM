package com.wisekiddo.mvvm.feature.trending;

import com.wisekiddo.mvvm.base.di.ScreenScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ScreenScope
@Subcomponent
public interface TrendingComponent extends AndroidInjector<TrendingController>{
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TrendingController>{

    }
}
