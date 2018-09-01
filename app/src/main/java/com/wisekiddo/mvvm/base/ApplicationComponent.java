package com.wisekiddo.mvvm.base;

import com.wisekiddo.mvvm.data.source.remote.ApiClientModule;
import com.wisekiddo.mvvm.data.source.remote.ApiServiceModule;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        ApiClientModule.class,
        ApiServiceModule.class,
})

public interface ApplicationComponent {
    void inject(ApplicationBase applicationBase);
}
