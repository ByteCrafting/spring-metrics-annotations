package br.com.bytecrafting.metrics.annotations.aspect

import br.com.bytecrafting.metrics.annotations.util.logger
import io.micrometer.core.instrument.composite.CompositeMeterRegistry
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
class MethodAspect(
    val meterRegistry: CompositeMeterRegistry
) {


    @Around("@annotation(br.com.bytecrafting.metrics.annotations.MetricExecutionTime)")
    fun logExecutionTime(joinPoint: ProceedingJoinPoint): Any? {
        val start = System.currentTimeMillis()

        val proceed = joinPoint.proceed()
        val metric = meterRegistry.counter(joinPoint.signature.name)

        metric.increment()


        val executionTime = System.currentTimeMillis() - start
        logger.info("${joinPoint.signature.name} executed in $executionTime ms")

        return proceed;
    }

    companion object{
        val logger = logger<MethodAspect>()
    }
}