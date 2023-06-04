package br.com.bytecrafting.metrics.annotations

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringMetricsAnnotationsApplication

fun main(args: Array<String>) {
	runApplication<SpringMetricsAnnotationsApplication>(*args)
}
