package com.wisekiddo.mvvm.data.source.remote;

import com.wisekiddo.mvvm.data.model.Repo;
import com.wisekiddo.mvvm.data.source.remote.ApiService;
import com.wisekiddo.mvvm.data.source.remote.responses.RepoItems;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RemoteRepository {

    private final ApiService service;

    @Inject
    RemoteRepository(ApiService service) {
        this.service = service;
    }

    public Single<List<Repo>> getItems() {
        return service.getRepositories()
                .map(new Function<RepoItems, List<Repo>>() {
                    @Override
                    public List<Repo> apply(RepoItems repoItems) throws Exception {
                        return repoItems.items();
                    }
                })
                .subscribeOn(Schedulers.io());
    }
}
