package com.kafka.demo.consumers;

import com.kafka.demo.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumeService {

    public static  final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumeService.class);
    @KafkaListener(topics = "Person", groupId = "myGroup")
    public void  consume(Person person){

        LOGGER.info("Message consumed is {}",person);

    }
}
