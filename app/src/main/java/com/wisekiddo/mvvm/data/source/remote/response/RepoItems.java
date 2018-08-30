package com.wisekiddo.mvvm.data.source.remote.response;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.wisekiddo.mvvm.data.model.Repo;

import java.util.List;

@AutoValue
public abstract class RepoItems {

    @Json(name ="items")
    public abstract List<Repo> items();

    public static JsonAdapter<RepoItems> jsonAdapter(Moshi moshi){
        return new AutoValue_RepoItems.MoshiJsonAdapter(moshi);
    }

}
