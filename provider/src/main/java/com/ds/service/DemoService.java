package com.ds.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

/**
 * @Author ds
 * @Date 2021/3/11 16:08
 * @Description sentinel 埋点限流demo
 */
@Service
public class DemoService {

    @SentinelResource(value = "sentinel_resource#bonjour",defaultFallback = "bonjourFallback")
    public String bonjour(String name){

        if(Math.random() * 10 < 5){
            throw new RuntimeException();
        }

        return "bonjour" + name;
    }

    public String bonjourFallback(Throwable t){

        if(BlockException.isBlockException(t)){
            return "Block by Sentinel " + t.getClass().getSimpleName();
        }

        return "Oops failed " + t.getClass().getCanonicalName();
    }

}
