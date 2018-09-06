package com.wisekiddo.mvvm.feature.trending;

import com.wisekiddo.mvvm.base.di.ScreenScope;
import com.wisekiddo.mvvm.data.model.Repo;
import com.wisekiddo.mvvm.data.source.remote.RemoteRepository;

import javax.inject.Inject;

import timber.log.Timber;

@ScreenScope
class TrendingPresenter implements RepoAdapter.RepoClickedListener {

    private final TrendingViewModel viewModel;
    private final RemoteRepository remoteRepository;

    @Inject
    TrendingPresenter(TrendingViewModel viewModel, RemoteRepository remoteRepository){
        this.viewModel = viewModel;
        this.remoteRepository = remoteRepository;
        loadRepos();
    }

    private void loadRepos() {
        remoteRepository.getItems()
                .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
                .doOnEvent((d, t) -> viewModel.loadingUpdated().accept(false))
                .subscribe(viewModel.reposUpdated(), viewModel.onError());
    }

    @Override
    public void onRepoClicked(Repo repo) {
        Timber.i("CLICKED", "Error loading Repos");
    }
}
