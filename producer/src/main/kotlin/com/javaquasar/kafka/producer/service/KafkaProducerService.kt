package com.javaquasar.kafka.producer.cofig

import com.javaquasar.kafka.producer.dto.UserEvent
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducerService(
    private val stringKafkaTemplate: KafkaTemplate<String, String>,
    private val jsonKafkaTemplate: KafkaTemplate<String, UserEvent>
) {

    fun sendText(topic: String, key: String, message: String) {
        stringKafkaTemplate.send(topic, key, message)
    }

    fun sendJson(topic: String, key: String, event: UserEvent) {
        jsonKafkaTemplate.send(topic, key, event)
    }

}