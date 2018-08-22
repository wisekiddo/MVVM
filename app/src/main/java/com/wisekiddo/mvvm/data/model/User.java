package com.wisekiddo.mvvm.data.model;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class User {
    public abstract long id();
    public abstract String login();

}
