package icu.shishc.kafka.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author: ShiShc
 * @date: 2021/7/8
 * @Desc:
 */
@Slf4j
@Component
public class KafkaConsumerListener {
    @KafkaListener(topics = "test_topic")
    public void onMessage(String msg) {
        log.info("get message: " + msg);
    }
}
