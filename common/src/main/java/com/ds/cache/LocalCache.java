package com.ds.cache;

import java.util.HashMap;
import java.util.Map;

public class LocalCache {
    static {
        System.out.println("初始化cache");
        cache = new HashMap();
    }
    public static Map<String,Object> cache;


}
