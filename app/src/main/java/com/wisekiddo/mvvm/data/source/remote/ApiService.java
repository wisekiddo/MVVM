package com.wisekiddo.mvvm.data.source.remote;

import com.wisekiddo.mvvm.data.source.remote.response.RepoItems;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("search/repositories?q=language:java&order=desc&sort=stars")
    Single<RepoItems> getRepositories();
}
