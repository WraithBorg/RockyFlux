package com.dddcs.dddcs.controller;

import com.dddcs.dddcs.entity.Commodity;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuples;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SseController {
    /**
     * 跳转到see.html
     * http://127.0.0.1:8889/sse
     */
    @RequestMapping("/sse")
    public String sse() {
        return "sse";
    }

    /**
     * 倒计时
     */
    private int count_down_sec = 3 * 60 * 60;
    @ResponseBody
    @GetMapping(value = "/sse/countDown", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<Object>> countDown() {

        return Flux.interval(Duration.ofSeconds(1))
                .map(seq -> Tuples.of(seq, getCountDownSec()))
                .map(data -> ServerSentEvent.<Object>builder()
                        .event("countDown")
                        .id(Long.toString(data.getT1()))
                        .data(data.getT2().toString())
                        .build());
    }

    private String getCountDownSec() {
        if (count_down_sec > 0) {
            int h = count_down_sec / (60 * 60);
            int m = (count_down_sec % (60 * 60)) / 60;
            int s = (count_down_sec % (60 * 60)) % 60;
            count_down_sec--;
            return "活动倒计时：" + h + " 小时 " + m + " 分钟 " + s + " 秒";
        }
        return "活动倒计时：0 小时 0 分钟 0 秒";
    }

    /**
     * // http://127.0.0.1:8889/sse
     */
    @ResponseBody
    @GetMapping(value = "/sse/findAll", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Commodity> findAll() {
        List<Commodity> commodities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Commodity obj = new Commodity();
            obj.setId(System.currentTimeMillis());
            obj.setShopId(1l);
            obj.setName("第" + i + "个商品");
            obj.setDetails("流式商品展示");
            obj.setPcs(1);
            obj.setPrice(new BigDecimal(998));
            obj.setType(1);
            commodities.add(obj);
        }
        return Flux.fromStream(commodities.stream()).delayElements(Duration.ofSeconds(1));
    }
}
