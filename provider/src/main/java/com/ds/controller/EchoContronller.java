package com.ds.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ds.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EchoContronller {

    @Resource
    DemoService demoService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/echo/{msg}")
    public String echo(@PathVariable String msg){
        return "Provider " + port +" " + msg;
    }

    @GetMapping("bonjour/{name}")
    public String bonjour(@PathVariable String name){
        return demoService.bonjour(name);
    }

}
