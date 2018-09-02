package com.wisekiddo.mvvm.data.source.remote;

import com.wisekiddo.mvvm.data.source.remote.responses.RepoItems;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.wisekiddo.mvvm.test.TestUtils;
import io.reactivex.Single;

@Singleton
public class TestApiService implements ApiService {

    private final TestUtils testUtils;
    private boolean sendError;

    @Inject
    TestApiService(TestUtils testUtils) {
        this.testUtils = testUtils;
    }

    @Override
    public Single<RepoItems> getRepositories() {
        if (!sendError) {
            RepoItems repoItems = testUtils.loadJson("mock/get_trending_repos.json", RepoItems.class);
            return Single.just(repoItems);
        }
        return Single.error(new IOException());
    }

    public void setSendError(boolean sendError) {
        this.sendError = sendError;
    }
}
