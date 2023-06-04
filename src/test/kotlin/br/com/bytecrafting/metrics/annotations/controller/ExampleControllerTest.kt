package br.com.bytecrafting.metrics.annotations.controller

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate


@SpringBootTest(webEnvironment = RANDOM_PORT)
class ExampleControllerTest {

    @Value(value = "\${local.server.port}")
    private val port = 0

    @Autowired
    private lateinit var restTemplate: TestRestTemplate
    @Test
    fun responsePost() {
        assertThat(
            restTemplate.getForObject(
                "http://localhost:$port/api/examples",
                String::class.java
            )
        ).contains("OK")
    }

    @Test
    fun responseOthers() {
        assertThat(
            restTemplate.getForObject(
                "http://localhost:$port/api/examples/others",
                String::class.java
            )
        ).contains("OK")
    }
}