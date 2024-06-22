package com.kafka.demo.producer;

import com.kafka.demo.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    public static  final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
    private KafkaTemplate<String, Person> kafkaTemplate;

    JsonKafkaProducer(KafkaTemplate<String,Person> kafkaTemplate){
       this.kafkaTemplate = kafkaTemplate;
    }

   public void publish(Person person){
       Message<Person> message = MessageBuilder
               .withPayload(person)
               .setHeader(KafkaHeaders.TOPIC, "Person")
               .build();
       kafkaTemplate.send(message);
       LOGGER.info("Person send to Kafka is {}",person);

    }
}
