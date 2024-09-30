package com.geekey.githubproxy;

import com.geekey.githubproxy.service.GetContentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GithubProxyApplicationTests {
    @Autowired
    private GetContentService service;
    @Test
    void contextLoads() {
        Long start = System.currentTimeMillis();
        Object byUrl = service.getByUrl("https://github.com/lingzhee/ios_rule_script/raw/refs/heads/master/rule/Clash/Global/Global.list");
        System.out.println(byUrl);
        Long end = System.currentTimeMillis();
        Long time = end - start;
        System.out.println("总用时 " +time);
    }

}
