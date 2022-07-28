package net.madeng.spring.kafka.controller;

import net.madeng.spring.kafka.service.KafkaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {
    private final KafkaService kafkaService;

    public KafkaController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping
    public void produce(@RequestBody KafkaMessageRequest kafkaMessageRequest) {
        kafkaService.produce(kafkaMessageRequest.getMessage());
    }

    public static class KafkaMessageRequest {
        private String message;

        public KafkaMessageRequest() {
        }

        public KafkaMessageRequest(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
