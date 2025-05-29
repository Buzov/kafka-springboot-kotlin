package com.javaquasar.kafka.producer.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.javaquasar.kafka.producer.cofig.KafkaProducerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/produce")
class KafkaController(
    private val producerService:KafkaProducerService
) {
    private val log: Logger = LoggerFactory.getLogger(KafkaController::class.java)

    @PostMapping
    fun produce(@RequestParam(defaultValue = "test") topic: String,
                      @RequestParam message: String): String {
        log.info("Producing message: $message")
        producerService.sendMessage(topic, message)
        return "Message sent to $topic"
    }
}