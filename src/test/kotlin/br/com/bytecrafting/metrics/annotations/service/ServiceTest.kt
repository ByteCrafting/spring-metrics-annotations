package br.com.bytecrafting.metrics.annotations.service

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.time.Duration

class ServiceTest {

    private val service: Service = Service()

    @Test
    fun execute() {

        assertTimeout(Duration.ofMillis(60)) {
            service.execute(50)
        }
    }
}