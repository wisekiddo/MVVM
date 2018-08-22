package com.wisekiddo.mvvm.base;

import android.content.Context;

import com.bluelinelabs.conductor.Controller;
import com.wisekiddo.mvvm.di.Injector;

import javax.annotation.Nonnull;

public abstract class ControllerBase extends Controller {
    private boolean injected = false;
    @Override protected void onContextAvailable(@Nonnull Context context){
        if(!injected){
            Injector.inject(this);
            injected=true;
        }
        super.onContextAvailable(context);
    }
}
