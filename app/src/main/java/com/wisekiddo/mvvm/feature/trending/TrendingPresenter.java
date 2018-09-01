package com.wisekiddo.mvvm.feature.trending;

import com.wisekiddo.mvvm.base.di.ScreenScope;
import com.wisekiddo.mvvm.data.model.Repo;
import com.wisekiddo.mvvm.data.source.remote.RemoteDataSource;

import javax.inject.Inject;

import timber.log.Timber;

@ScreenScope
class TrendingPresenter implements RepoAdapter.RepoClickedListener {

    private final TrendingViewModel viewModel;
    private final RemoteDataSource remoteDataSource;

    @Inject
    TrendingPresenter(TrendingViewModel viewModel, RemoteDataSource remoteDataSource){
        this.viewModel = viewModel;
        this.remoteDataSource = remoteDataSource;
        loadRepos();
    }

    private void loadRepos() {
        remoteDataSource.getRepositories()
                .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
                .doOnEvent((d, t) -> viewModel.loadingUpdated().accept(false))
                .subscribe(viewModel.reposUpdated(), viewModel.onError());
    }

    @Override
    public void onRepoClicked(Repo repo) {
        Timber.i("CLICKED", "Error loading Repos");
    }
}
