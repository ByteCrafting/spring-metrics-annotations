# Spring Metrics Annotations

[![Build](https://github.com/ByteCrafting/spring-metrics-annotations/actions/workflows/build.yml/badge.svg)](https://github.com/ByteCrafting/spring-metrics-annotations/actions/workflows/build.yml)

This application provides an example of using [Spring AOP](https://www.baeldung.com/spring-aop) (Aspect Oriented Programming) to execute code before or after a specific method using custom annotations.
Additionally, this project demonstrates the usage of  [Micrometer](https://micrometer.io/) for Prometheus to create custom metrics.

## Instructions

To build and run the application, you can use either an IDE or Maven.

Once the application is running, you can execute the following curl commands to interact with the endpoints:

```shell
curl --request GET \
  --url http://localhost:9002/api/examples
  
curl --request GET \
  --url http://localhost:9002/api/examples/others
  
curl --request GET \
  --url http://localhost:9002/api/actuator/prometheus
```
When you send the last request, the response will contain all the metrics generated by your application. You can search for specific method names (e.g., responsePost, responseOthers) to locate the corresponding metrics.
