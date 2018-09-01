package com.wisekiddo.mvvm.base.di;


import android.app.Activity;
import android.content.Context;

import com.wisekiddo.mvvm.base.ActivityBase;
import com.wisekiddo.mvvm.base.ApplicationBase;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.android.AndroidInjector;

public class ActivityInjector {

    private final Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>> activityInjectors;
    private final Map<String, AndroidInjector<? extends Activity>> cache = new HashMap<>();

    @Inject
    ActivityInjector(Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>> activityInjectors) {
        this.activityInjectors = activityInjectors;
    }

    void inject(Activity activity) {
        if (!(activity instanceof ActivityBase)) {
            throw new IllegalArgumentException("Activity must extend BaseActivity");
        }

        String instanceId = ((ActivityBase) activity).getInstanceId();
        if (cache.containsKey(instanceId)) {
            //noinspection unchecked
            ((AndroidInjector<Activity>) cache.get(instanceId)).inject(activity);
            return;
        }

        //noinspection unchecked
        AndroidInjector.Factory<Activity> injectorFactory =
                (AndroidInjector.Factory<Activity>) activityInjectors.get(activity.getClass()).get();
        AndroidInjector<Activity> injector = injectorFactory.create(activity);
        cache.put(instanceId, injector);
        injector.inject(activity);
    }

    void clear(Activity activity) {
        if (!(activity instanceof ActivityBase)) {
            throw new IllegalArgumentException("Activity must extend BaseActivity");
        }
        cache.remove(((ActivityBase) activity).getInstanceId());
    }

    static ActivityInjector get(Context context) {
        return ((ApplicationBase) context.getApplicationContext()).getActivityInjector();
    }
}
