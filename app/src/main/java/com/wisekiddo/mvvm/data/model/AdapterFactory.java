package com.wisekiddo.mvvm.data.model;

import com.ryanharter.auto.value.moshi.MoshiAdapterFactory;
import com.squareup.moshi.JsonAdapter;

@MoshiAdapterFactory
public abstract class AdapterFactory implements JsonAdapter.Factory{

    public static JsonAdapter.Factory create(){
        return new AutoValueMoshi_AdapterFactory();
    }

}
