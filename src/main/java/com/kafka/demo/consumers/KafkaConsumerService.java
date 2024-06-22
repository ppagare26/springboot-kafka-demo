package com.kafka.demo.consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    public static  final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);
@KafkaListener(topics = "myFirstTopic", groupId = "myGroup")
    public void  consume(String message){

    LOGGER.info("Message consumed is {}",message);

    }
}
