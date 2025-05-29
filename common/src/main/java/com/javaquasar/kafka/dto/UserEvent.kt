package com.javaquasar.kafka.dto

data class UserEvent(
    val id: String,
    val name: String,
    val timestamp: Long
)