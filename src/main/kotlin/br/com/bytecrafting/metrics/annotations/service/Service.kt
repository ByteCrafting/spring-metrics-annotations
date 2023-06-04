package br.com.bytecrafting.metrics.annotations.service

import org.springframework.stereotype.Service

@Service
class Service {

    fun execute(value: Long) {
        Thread.sleep(value)
    }
}