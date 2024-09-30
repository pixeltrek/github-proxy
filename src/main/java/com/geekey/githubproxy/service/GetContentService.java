package com.geekey.githubproxy.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class GetContentService {
    private final RestTemplate restTemplate;
    private final String HTTPS = "https://";
    public GetContentService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    public Object getByUrl(String url) {
        log.info("getByUrl Looking up {}", url);
        ResponseEntity<String> forEntity = restTemplate.getForEntity(HTTPS + url, String.class);
        return forEntity.getBody();
    }

    @Async
    public CompletableFuture<String> asyncGetByUrl(String url) throws InterruptedException {
        log.info("asyncGetByUrl Looking up {}",url);
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        String response = forEntity.getBody();
        return  CompletableFuture.completedFuture(response);
    }

}
