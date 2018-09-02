package com.wisekiddo.mvvm.base;

import com.wisekiddo.mvvm.base.director.NavigatorModule;
import com.wisekiddo.mvvm.data.source.remote.ApiClientModule;
import com.wisekiddo.mvvm.data.source.remote.TestApiServiceModule;
import com.wisekiddo.mvvm.feature.trending.TestTrendingController;


import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        TestActivityBindingModule.class,
        TestApiServiceModule.class,
        ApiClientModule.class,
        NavigatorModule.class,
})
public interface TestApplicationComponent extends ApplicationComponent {

    void inject(TestTrendingController trendingReposControllerTest);
}
