package com.wisekiddo.mvvm.base.director;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;

public interface Navigator {
    void initWithRouter(Router router, Controller controller);
    boolean pop();
    void clear();
}
