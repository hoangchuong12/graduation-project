package com.thaihoangchuong.bannerservice.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class WebConfig {

    @Bean
    public HttpMessageConverters customConverters() {
        return new HttpMessageConverters(
                new ByteArrayHttpMessageConverter(),
                new StringHttpMessageConverter(),
                new MappingJackson2HttpMessageConverter()
        );
    }
}
