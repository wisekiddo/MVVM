package com.wisekiddo.mvvm.data.source.remote;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.wisekiddo.mvvm.data.model.Repo;

import java.util.List;

@AutoValue
public abstract class ApiResponse {

    @Json(name ="items")
    public List<Repo> repos;

    public static JsonAdapter<ApiResponse> jsonAdapter(Moshi moshi){
        return new AutoValue_ApiResponse.MoshiJsonAdapter(moshi);
    }
}
