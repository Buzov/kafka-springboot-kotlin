package com.javaquasar.kafka.producer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProducerApplication

fun main(args: Array<String>) {
	runApplication<ProducerApplication>(*args)
}
