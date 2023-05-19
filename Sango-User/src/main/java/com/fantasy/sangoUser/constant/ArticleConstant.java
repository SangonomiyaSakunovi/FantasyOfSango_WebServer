package com.fantasy.sangoUser.constant;

import java.util.HashMap;
import java.util.Map;

public class ArticleConstant {
    public static final String NEWEST = "newest";
    public static final String ANNOUNCEMENT = "announcement";
    public static final String NEWS = "news";
    public static final String ACTIVITY = "activity";
    public static final Map<String,Integer> TYPE_MAP = new HashMap<>();
    static {
        TYPE_MAP.put(NEWEST,0);
        TYPE_MAP.put(ANNOUNCEMENT,1);
        TYPE_MAP.put(NEWS,2);
        TYPE_MAP.put(ACTIVITY,3);
    }
}
