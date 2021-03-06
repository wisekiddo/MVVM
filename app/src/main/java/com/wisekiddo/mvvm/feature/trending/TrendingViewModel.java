package com.wisekiddo.mvvm.feature.trending;

import com.jakewharton.rxrelay2.BehaviorRelay;
import com.wisekiddo.mvvm.R;
import com.wisekiddo.mvvm.base.di.ScreenScope;
import com.wisekiddo.mvvm.data.model.Repo;

import java.util.List;
import java.util.Observable;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;
import timber.log.Timber;

@ScreenScope
class TrendingViewModel {

    private final BehaviorRelay<List<Repo>> reposRelay = BehaviorRelay.create();
    private final BehaviorRelay<Integer> errorRelay = BehaviorRelay.create();
    private final BehaviorRelay<Boolean> loadingRelay = BehaviorRelay.create();

    @Inject
    TrendingViewModel(){

    }

    io.reactivex.Observable<Boolean> loading() {
        return loadingRelay;
    }

    io.reactivex.Observable<List<Repo>> repos() {
        return reposRelay;
    }

    io.reactivex.Observable<Integer> error() {
        return errorRelay;
    }

    Consumer<Boolean> loadingUpdated() {
        return loadingRelay;
    }

    Consumer<List<Repo>> reposUpdated() {
        errorRelay.accept(-1);
        return reposRelay;
    }

    Consumer<Throwable> onError() {
        return throwable -> {
            Timber.e(throwable, "Error loading Repos");
            errorRelay.accept(R.string.api_error_repos);
        };
    }
}
