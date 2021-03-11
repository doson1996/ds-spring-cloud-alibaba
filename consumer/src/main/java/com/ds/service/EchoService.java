package com.ds.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ds.result.Result;
import com.ds.service.fallback.EchoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(value = "provider",fallback = EchoServiceFallback.class,configuration = FeignConfiguration.class)
@FeignClient(value = "provider",fallback = EchoServiceFallback.class)
public interface EchoService {

    @GetMapping("/echo/{msg}")
    String echo(@PathVariable String msg);

    @GetMapping("/test/{msg}")
    Result test(@PathVariable String msg);

    @GetMapping("bonjour/{name}")
    String bonjour(@PathVariable String name);
}
