package com.wisekiddo.mvvm.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;

public interface Navigator {
    void initWithRouter(Router router, Controller controller);
    boolean pop();
    void clear();
}
