package com.javaquasar.kafka.consumer.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer {

    private val log: Logger = LoggerFactory.getLogger(KafkaConsumer::class.java)

    @KafkaListener(
        topics = ["user-events"],
        groupId = "user-event-consumer-group"
    )
    fun consume(message: String) {
        log.info("Received message: $message")
    }

}