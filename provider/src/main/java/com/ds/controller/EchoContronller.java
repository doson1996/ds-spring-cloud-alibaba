package com.ds.controller;

import com.ds.cache.LocalCache;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoContronller {

    @Value("${server.port}")
    private String port;

    @GetMapping("/echo/{msg}")
    public String echo(@PathVariable String msg){
        Object test = LocalCache.cache.get("test");
        System.out.println("LocalCache---" + test);
        return "Provider " + port +" " + msg;
    }

}
