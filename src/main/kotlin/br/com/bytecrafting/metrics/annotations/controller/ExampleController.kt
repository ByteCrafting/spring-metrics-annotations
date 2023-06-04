package br.com.bytecrafting.metrics.annotations.controller

import br.com.bytecrafting.metrics.annotations.MetricExecutionTime
import br.com.bytecrafting.metrics.annotations.service.Service
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/examples"])
class ExampleController(
    val service: Service
) {

    @GetMapping
    @MetricExecutionTime
    fun responsePost(): ResponseEntity<Any> {
        service.execute(200)
        return ResponseEntity.ok("OK")
    }

    @GetMapping(value = ["/others"])
    @MetricExecutionTime
    fun responseOthers(): ResponseEntity<Any> {
        service.execute(100)
        return ResponseEntity.ok("OK")
    }
}