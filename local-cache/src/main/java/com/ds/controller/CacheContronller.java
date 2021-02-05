package com.ds.controller;

import com.ds.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("cache")
public class CacheContronller {

    public static Map<String,Object> cache = new ConcurrentHashMap<>();

    @GetMapping("get/{key}")
    public Object get(@PathVariable String key){
        if(StringUtils.isEmpty(key)){
            return null;
        }
        return cache.get(key);
    }

    @PostMapping("set")
    public int set(@RequestParam String key,@RequestParam Object value){
        if(StringUtils.isEmpty(key)){
            return 0;
        }
        Object result = cache.put(key, value);
        return result == null ? 0 : 1 ;
    }

    @GetMapping("all")
    public Result all(){
        return Result.success(cache) ;
    }

}
