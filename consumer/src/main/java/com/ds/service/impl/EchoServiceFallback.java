package com.ds.service.impl;

import com.ds.service.EchoService;
import org.springframework.stereotype.Service;

@Service
public class EchoServiceFallback implements EchoService {
    @Override
    public String echo(String msg) {
        System.err.println("发生熔断---");
        return "EchoService Fallback";
    }
}

