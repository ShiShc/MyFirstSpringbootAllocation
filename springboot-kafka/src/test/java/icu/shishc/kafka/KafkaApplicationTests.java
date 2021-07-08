package icu.shishc.kafka;

import icu.shishc.kafka.entity.Message;
import icu.shishc.kafka.service.KafkaService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: ShiShc
 * @date: 2021/7/8
 * @Desc:
 */
@Slf4j
@SpringBootTest
public class KafkaApplicationTests {
    @Autowired
    private KafkaService kafkaService;

    @Test
    void sendMessageTest() throws Exception {
        Message<String> message = new Message<>();
        message.setId("1");
        message.setContent("test_msg");
        kafkaService.sendMessage(message.toString());
        Thread.currentThread().sleep(10000);
    }

    @BeforeEach
    void testBefore() {
        log.info("-----before-----");
    }

    @AfterEach
    void testAfter() {
        log.info("-----after-----");
    }
}
