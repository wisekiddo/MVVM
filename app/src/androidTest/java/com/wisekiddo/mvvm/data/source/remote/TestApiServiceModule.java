package com.wisekiddo.mvvm.data.source.remote;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class TestApiServiceModule {

    @Binds
    abstract ApiService bindRepoService(TestApiService repoService);
}
