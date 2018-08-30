package com.wisekiddo.mvvm.data.source.remote;

import com.wisekiddo.mvvm.data.model.Repo;
import com.wisekiddo.mvvm.data.source.remote.response.RepoItems;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class ApiRequester {

    private final ApiService service;

    @Inject
    ApiRequester(ApiService service) {
        this.service = service;
    }

    Single<List<Repo>> getRepositories() {
        return service.getRepositories()
                .map(RepoItems::items)
                .subscribeOn(Schedulers.io());
    }
}
