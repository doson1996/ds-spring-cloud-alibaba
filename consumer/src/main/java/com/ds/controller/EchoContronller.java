package com.ds.controller;

import com.ds.cache.LocalCache;
import com.ds.result.Result;
import com.ds.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class EchoContronller {

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private EchoService echoService;

    @Autowired
    private Environment environment;

    @GetMapping(value = "/echo-rest/{msg}")
    public String rest(@PathVariable String msg) {
        return restTemplate.getForObject("http://provider/echo/" + msg+"  -restTemplate", String.class);
    }

    @GetMapping(value = "/echo-fegin/{msg}")
    public String fegin(@PathVariable String msg) {
        String username = environment.getProperty("user.name");
        LocalCache.cache.put("username",username);
        return echoService.echo(msg+"  NacosConfig username-" + username + "    -fegin");
    }

    @GetMapping(value = "/test")
    public Result test() {
        return Result.success("",LocalCache.cache.get("username"));
    }



}
