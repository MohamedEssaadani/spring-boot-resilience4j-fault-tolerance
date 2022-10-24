package org.essaadani.springbootresilience4jfaulttolerance.controllers;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.essaadani.springbootresilience4jfaulttolerance.services.ServiceCaller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ServiceRESTController {
    private final ServiceCaller serviceCaller;

    public ServiceRESTController(ServiceCaller serviceCaller) {
        this.serviceCaller = serviceCaller;
    }

    @GetMapping("/api-call-cb")
    @CircuitBreaker(name = "CircuitBreakerService", fallbackMethod = "fallbackAfterRetry")
    public String callApi(){
        return serviceCaller.callExternalApi();
    }

    @GetMapping("/api-call-retry")
    @Retry(name = "retryApi", fallbackMethod = "fallbackAfterRetry")
    public String callApiTwo(){
        return serviceCaller.callExternalApi();
    }

    public String fallbackAfterRetry(Exception ex) {
        return "all retries have exhausted";
    }

}
