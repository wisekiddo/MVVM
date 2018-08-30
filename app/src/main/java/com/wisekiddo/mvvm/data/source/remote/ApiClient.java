package com.wisekiddo.mvvm.data.source.remote;

import com.squareup.moshi.Moshi;
import com.wisekiddo.mvvm.data.model.AdapterFactory;
import com.wisekiddo.mvvm.data.model.ZoneDateTimeAdapter;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public abstract class ApiClient {

    @Provides
    @Singleton
    static Moshi provideMoshi(){
        return new Moshi.Builder()
                .add(AdapterFactory.create())
                .add(new ZoneDateTimeAdapter())
                .build();
    }

    @Provides
    @Singleton
    static Retrofit provideRetrofit(Moshi moshi, Call.Factory callFactory, @Named("base_url") String baseUrl){
        return new Retrofit.Builder()
                .callFactory(callFactory)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }
}
