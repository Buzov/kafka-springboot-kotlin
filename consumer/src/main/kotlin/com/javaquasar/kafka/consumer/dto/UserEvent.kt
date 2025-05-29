package com.javaquasar.kafka.consumer.dto

data class UserEvent(
    val id: String,
    val name: String,
    val timestamp: Long
)