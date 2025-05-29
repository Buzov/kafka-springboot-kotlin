package com.javaquasar.kafka.producer.controller

import org.apache.kafka.clients.admin.AdminClient
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/kafka")
class KafkaTopicController(private val adminClient: AdminClient) {

    @PostMapping("/create-topic")
    fun createTopic(
        @RequestParam name: String?,
        @RequestParam(defaultValue = "3") partitions: Int,
        @RequestParam(defaultValue = "1") replicationFactor: Short
    ): ResponseEntity<String?> {
        val newTopic = NewTopic(name, partitions, replicationFactor)

        try {
            adminClient.createTopics(mutableListOf<NewTopic?>(newTopic)).all().get()
            return ResponseEntity.ok<String?>("Topic '" + name + "' created.")
        } catch (e: Exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body<String?>("Error creating topic: " + e.message)
        }
    }

}