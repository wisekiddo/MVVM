package com.wisekiddo.mvvm.feature.trending;

import com.wisekiddo.mvvm.R;
import com.wisekiddo.mvvm.data.source.remote.responses.RepoItems;
import com.wisekiddo.mvvm.testutil.TestUtils;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

import io.reactivex.observers.TestObserver;

public class TrendingViewModelTest {

    private TrendingViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        viewModel = new TrendingViewModel();
    }

    @Test
    public void loading() throws Exception{
        TestObserver<Boolean> loadingObserver = viewModel.loading().test();
        viewModel.loadingUpdated().accept(true);
        viewModel.loadingUpdated().accept(false);

        loadingObserver.assertValues(true, false);
    }

    @Test
    public void repos() throws Exception{
        RepoItems repoItems = TestUtils.loadJson("mock/get_trending_repos.json", RepoItems.class);
        viewModel.reposUpdated().accept(repoItems.items());

        viewModel.repos().test().assertValue(repoItems.items());
    }

    @Test
    public void error() throws Exception {
        TestObserver<Integer> errorObserver = viewModel.error().test();
        viewModel.onError().accept(new IOException());
        viewModel.reposUpdated().accept(Collections.emptyList());

        errorObserver.assertValues(R.string.api_error_repos, -1);
    }
}