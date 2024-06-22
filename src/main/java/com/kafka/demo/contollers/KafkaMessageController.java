package com.kafka.demo.contollers;

import com.kafka.demo.producer.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/kafka/v1/producer")
public class KafkaMessageController {
    private KafkaProducerService kafkaProducerService;

    public KafkaMessageController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }
    //http://localhost:8080/api/kafka/v1/producer/publish?message?Hello World
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam ("message") String message){
        kafkaProducerService.sendMessage(message);
        return   ResponseEntity.ok(message);
    }
}
