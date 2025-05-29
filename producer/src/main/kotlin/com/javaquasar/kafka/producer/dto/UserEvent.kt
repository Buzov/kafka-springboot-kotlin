package com.javaquasar.kafka.producer.dto

data class UserEvent(
    val id: String,
    val name: String,
    val timestamp: Long
)