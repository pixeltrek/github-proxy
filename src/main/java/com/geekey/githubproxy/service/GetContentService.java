package com.geekey.githubproxy.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
public class GetContentService {
    // 使用springboot内置的restTemplate请求数据
    private final RestTemplate restTemplate;

    public GetContentService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    public Object getByUrl(String url) {
        log.info("getByUrl Looking up {}", url);
        String HTTPS = "https://";
        ResponseEntity<String> forEntity = restTemplate.getForEntity(HTTPS + url, String.class);
        return forEntity.getBody();
    }



}
