package com.javaquasar.kafka.producer.controller

import com.javaquasar.kafka.producer.cofig.KafkaProducerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/produce")
class KafkaController(
    private val producerService:KafkaProducerService
) {

    @PostMapping
    fun produce(@RequestParam topic: String, @RequestParam message: String): String {
        producerService.sendMessage(topic, message)
        return "Message sent to $topic"
    }
}