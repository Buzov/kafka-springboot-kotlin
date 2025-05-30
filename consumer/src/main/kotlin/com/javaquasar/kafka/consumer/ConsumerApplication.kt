package com.javaquasar.kafka.consumer

import com.javaquasar.kafka.producer.cofig.KafkaProducerConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(KafkaProducerConfig::class)
class ConsumerApplication

fun main(args: Array<String>) {
	runApplication<ConsumerApplication>(*args)
}
