package com.geekey.githubproxy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class GetContentService {
    // 使用springboot内置的restTemplate请求数据
    private final RestTemplate restTemplate;
    public GetContentService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    // log对象
    private static final Logger log = LoggerFactory.getLogger(GetContentService.class);

    public Object getByUrl(String url) {
        log.info("【获取链接内容】 url = {}", url);
        String HTTPS = "https://";
        ResponseEntity<String> forEntity = restTemplate.getForEntity(HTTPS + url, String.class);
        return forEntity.getBody();
    }



}
