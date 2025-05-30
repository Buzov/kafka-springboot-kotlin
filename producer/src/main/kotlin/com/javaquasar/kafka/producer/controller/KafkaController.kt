package com.javaquasar.kafka.producer.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.javaquasar.kafka.producer.cofig.KafkaProducerService
import com.javaquasar.kafka.dto.UserEvent
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/produce")
class KafkaController(
    private val producerService:KafkaProducerService
) {
    private val log: Logger = LoggerFactory.getLogger(KafkaController::class.java)

    // String -> String
    @PostMapping("/text")
    fun produce(
        @RequestParam(defaultValue = "text-topic") topic: String,
        @RequestParam key: String,
        @RequestParam message: String
    ): String {
        log.info("Producing text message to topic=$topic: $key: $message")
        producerService.sendText(topic, key, message)
        return "Text message sent to $topic"
    }

    // String -> JSON
    @PostMapping("/json")
    fun produceJson(
        @RequestParam(defaultValue = "user-events") topic: String,
        @RequestParam key: String,
        @RequestBody event: UserEvent
    ): String {
        log.info("Producing JSON message to topic=$topic: $key: $event")
        producerService.sendJson(topic, key, event)
        return "JSON message sent to $topic"
    }

}