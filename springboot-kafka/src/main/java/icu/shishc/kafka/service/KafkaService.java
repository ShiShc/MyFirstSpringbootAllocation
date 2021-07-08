package icu.shishc.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author: ShiShc
 * @date: 2021/7/8
 * @Desc:
 */
@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public boolean sendMessage(String msg) {
        kafkaTemplate.send("test_topic", msg);
        return true;
    }
}
