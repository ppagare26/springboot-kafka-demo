package com.kafka.demo.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    public static  final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

    private KafkaTemplate<String,String> kafkaTemplate ;
@Autowired
    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String msg){
        LOGGER.info("Message is {}",msg);
        kafkaTemplate.send("myFirstTopic", msg);
    }
}
