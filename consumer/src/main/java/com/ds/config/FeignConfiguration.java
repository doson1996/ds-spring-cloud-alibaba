package com.ds.config;

import com.ds.service.fallback.EchoServiceFallback;
import org.springframework.context.annotation.Bean;

//@Configuration
public class FeignConfiguration {
    @Bean
    public EchoServiceFallback echoServiceFallback() {
        return new EchoServiceFallback();
    }
}
