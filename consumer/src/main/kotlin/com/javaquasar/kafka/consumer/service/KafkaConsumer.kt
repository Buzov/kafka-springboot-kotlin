package com.javaquasar.kafka.consumer.service

import com.javaquasar.kafka.dto.UserEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer {

    private val log: Logger = LoggerFactory.getLogger(KafkaConsumer::class.java)

    @KafkaListener(
        topics = ["text-topic"],
        groupId = "string-consumer-group",
        containerFactory = "stringKafkaListenerContainerFactory"
    )
    fun consume(message: String) {
        log.info("Received message: $message")
    }

    // ✅ String → JSON
    @KafkaListener(
        topics = ["user-events"],
        groupId = "json-consumer-group",
        containerFactory = "jsonKafkaListenerContainerFactory"
    )
    fun listenUserEvent(event: UserEvent) {
        log.info("Consumed UserEvent: $event")
    }

}