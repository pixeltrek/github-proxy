package com.geekey.githubproxy.controller;

import com.geekey.githubproxy.service.GetContentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;


@RestController
@Slf4j
public class GetContentController {

    @Value("${domains}")
    private String[] domains;
    @Value("${file_suffixs}")
    private String[] suffixs;
    @Autowired
    private GetContentService getContentService;

    private final String HTTPS = "https://";
    @GetMapping("/**")
    @ResponseBody
    public void getUrlContent(HttpServletRequest request,HttpServletResponse response) throws IOException {
        // 设置响应的字符编码和Content-Type 指定UTF-8编码 设置内容类型为文本文件
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");

        // 获取uri和去除uri开头的/
        String uri = request.getRequestURI();

        // 1.判断是否https://开头
        String[] split = uri.split(HTTPS);
        // 等于2表示用户只写了一个链接 防止用户不按套路出牌
        if (split.length == 2) {
            // 2.判断是否在允许域名内
            for (String domain : domains) {
                if (split[1].startsWith(domain)) {
                    // 3.判断是否在允许文件后缀内
                    for (String suffix : suffixs) {
                        if (split[1].endsWith(suffix)) {
                            // 进行网络io获取网址内容
                            String content = getContentService.getByUrl(split[1]).toString();
                            // 获取到的内容返回给用户
                            response.getWriter().write(content);
                            return;
                        }
                    }
                }

            }
        }
        response.getWriter().write("域名或文件后缀不在允许范围内");
    }

    //@GetMapping("/a/**")
    public CompletableFuture<String> asyncGetUrlContent(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
        // 获取uri和去除uri开头的/
        String uri = request.getRequestURI().substring(1);

        // 记录原始url方便后续请求
        String originalUrl = uri;

        // 1.判断是否https://开头
        if (uri.startsWith("https://")) {
            uri = uri.substring(8);
            // 2.判断是否在允许域名内
            for (String domain : domains) {
                if (uri.startsWith(domain)) {
                    // 3.判断是否在允许文件后缀内
                    for (String suffix : suffixs) {
                        if (uri.endsWith(suffix)) {
                            // 进行网络io获取网址内容

                            return getContentService.asyncGetByUrl(originalUrl);

                        }
                    }
                }

            }
        } else {
            // TODO 提示不是https开头
        }
        // 2.判断是否是允许域名
        // 3.判断文件类型
        // TODO 提示域名或后缀不合法
        return CompletableFuture.completedFuture("Error: ");
    }

}
