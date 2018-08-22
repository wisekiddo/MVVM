package com.wisekiddo.mvvm.ui;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class NavigatorModule {
    @Binds
    abstract Navigator provideNavigator(ScreenNavigator screenNavigator);
}
