package com.ds.service.fallback;

import com.ds.result.Result;
import com.ds.service.EchoService;
import org.springframework.stereotype.Service;

@Service
public class EchoServiceFallback implements EchoService {
    @Override
    public String echo(String msg) {
        System.err.println("发生熔断---");
        return "EchoService Fallback";
    }

    @Override
    public Result test(String msg) {

        return Result.fail(msg);
    }

    @Override
    public String bonjour(String name) {
        return null;
    }
}

