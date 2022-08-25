package com.dddcs.dddcs.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ZeroCopyHttpOutputMessage;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

/**
 * 首页
 */
@Controller
public class IndexController {


    /**
     * http://127.0.0.1:8889/flux
     */
    @GetMapping("/flux")
    @ResponseBody
    public Flux<String> flux() {
        return Flux.just("hello", "webflux", "spring", "boot").delayElements(Duration.ofSeconds(1));
    }
    /**
     * http://127.0.0.1:8889/flux
     */
    @GetMapping("/Mono")
    @ResponseBody
    public Mono<String> findById( ) {
        return Mono.just("Mono");
    }

    /**
     *
     * @param response
     * @param filename
     * @return
     */
    @GetMapping("download3/{filename}")
    public Mono<Void> download (ServerHttpResponse response, @PathVariable String filename) {
        ZeroCopyHttpOutputMessage zeroCopyResponse = (ZeroCopyHttpOutputMessage) response;
        response.getHeaders().set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);
        response.getHeaders().setContentType(MediaType.APPLICATION_PDF);
        File file = new File("D:\\zxu_download\\" + filename);
        return zeroCopyResponse.writeWith(file, 0, file.length());
    }

}
