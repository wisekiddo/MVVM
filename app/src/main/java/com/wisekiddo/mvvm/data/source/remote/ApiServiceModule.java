package com.wisekiddo.mvvm.data.source.remote;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public abstract class ApiServiceModule {
    @Provides
    @Singleton
    static ApiService provideRepoService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

}
