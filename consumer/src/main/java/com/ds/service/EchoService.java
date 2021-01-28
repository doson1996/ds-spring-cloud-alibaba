package com.ds.service;

import com.ds.config.FeignConfiguration;
import com.ds.service.impl.EchoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(value = "provider",fallback = EchoServiceFallback.class,configuration = FeignConfiguration.class)
@FeignClient(value = "provider",fallback = EchoServiceFallback.class)
public interface EchoService {
    @GetMapping("/echo/{msg}")
    String echo(@PathVariable String msg);
}
