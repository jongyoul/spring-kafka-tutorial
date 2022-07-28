package net.madeng.spring.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaService.class);
    private static final String KAFKA_TOPIC = "test-topic";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(String message) {
        kafkaTemplate.send(KAFKA_TOPIC, message);
    }

    @KafkaListener(topics = KAFKA_TOPIC, groupId = "spring-kafka-test-group")
    public void consume(String message) {
        logger.info("message : " + message);
    }
}
