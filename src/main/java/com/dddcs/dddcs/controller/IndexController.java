package com.dddcs.dddcs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Controller
public class IndexController {


    /**
     * http://127.0.0.1:8889/flux
     */
    @GetMapping("flux")
    @ResponseBody
    public Flux<String> flux() {
        return Flux.just("hello\n        ", "webflux\n       ", "spring\n       ", "boot\n       ").delayElements(Duration.ofSeconds(1));
    }
    /**
     * http://127.0.0.1:8889/flux
     */
    @GetMapping("Mono")
    @ResponseBody
    public Mono<String> findById( ) {
        return Mono.just("Mono");
    }
}
