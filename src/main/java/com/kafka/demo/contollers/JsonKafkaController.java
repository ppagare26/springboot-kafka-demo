package com.kafka.demo.contollers;

import com.kafka.demo.model.Person;
import com.kafka.demo.producer.JsonKafkaProducer;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka/v1")
public class JsonKafkaController {

    private JsonKafkaProducer jsonKafkaProducer;

    public JsonKafkaController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/person")
    public ResponseEntity<String> publish(@RequestBody Person person){
        jsonKafkaProducer.publish(person);
        return ResponseEntity.ok("Success"+ person.getFirstName());

    }
}
