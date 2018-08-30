package com.wisekiddo.mvvm.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.ControllerChangeHandler;
import com.bluelinelabs.conductor.Router;
import com.wisekiddo.mvvm.R;
import com.wisekiddo.mvvm.base.di.Injector;
import com.wisekiddo.mvvm.base.di.ScreenInjector;
import com.wisekiddo.mvvm.director.Navigator;

import java.util.UUID;

import javax.inject.Inject;

public abstract class ActivityBase extends AppCompatActivity {
    private static String INSTANCE_ID_KEY = "instance_id";

    @Inject
    ScreenInjector screenInjector;
    @Inject
    Navigator navigator;



    private String instanceId;
    private Router router;

    @Override
    protected void onCreate(@android.support.annotation.Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            instanceId = savedInstanceState.getString(INSTANCE_ID_KEY);
        } else {
            instanceId = UUID.randomUUID().toString();
        }
        Injector.inject(this);

        setContentView(layoutRes());
        ViewGroup screenContainer = findViewById(R.id.screen_container);
        if (screenContainer == null) {
            throw new NullPointerException("Activity must have a view with id: screen_container");
        }

        navigator.initWithRouter(router,initialScreen());
        router = Conductor.attachRouter(this, screenContainer, savedInstanceState);
        monitorBackStack();
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(INSTANCE_ID_KEY, instanceId);
    }

    @Override
    public void onBackPressed() {
        if(!navigator.pop()) {
            super.onBackPressed();
        }
    }


    @LayoutRes
    protected abstract int layoutRes();

    protected abstract Controller initialScreen();

    public String getInstanceId() {
        return instanceId;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        navigator.clear();
        if (isFinishing()) {
            Injector.clearComponent(this);
        }
    }

    public ScreenInjector  getScreenInjector() {
        return screenInjector;
    }

    private void monitorBackStack() {
        router.addChangeListener(new ControllerChangeHandler.ControllerChangeListener() {
            @Override
            public void onChangeStarted(
                    @android.support.annotation.Nullable Controller to,
                    @android.support.annotation.Nullable Controller from,
                    boolean isPush,
                    @NonNull ViewGroup container,
                    @NonNull ControllerChangeHandler handler) {
            }

            @Override
            public void onChangeCompleted(
                    @android.support.annotation.Nullable Controller to,
                    @android.support.annotation.Nullable Controller from,
                    boolean isPush,
                    @NonNull ViewGroup container,
                    @NonNull ControllerChangeHandler handler) {
                if (!isPush && from != null) {
                    Injector.clearComponent(from);
                }
            }
        });
    }
}
