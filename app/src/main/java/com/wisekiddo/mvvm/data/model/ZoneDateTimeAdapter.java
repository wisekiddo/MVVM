package com.wisekiddo.mvvm.data.model;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import org.threeten.bp.ZonedDateTime;

import javax.annotation.Nullable;

public class ZoneDateTimeAdapter {

    @FromJson
    ZonedDateTime fromJson(String json){
        return ZonedDateTime.parse(json);
    }
    @ToJson
    String toJson(@Nullable ZonedDateTime value){
        return value != null ? value.toString() : null;
    }
}
