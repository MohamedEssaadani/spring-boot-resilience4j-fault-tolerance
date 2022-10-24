package org.essaadani.springbootresilience4jfaulttolerance.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ServiceCaller {
    private final RestTemplate restTemplate;
    String url = "http://localhost:8989/";

    public ServiceCaller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public String callExternalApi() {
        return restTemplate.getForObject(
                url,
                String.class
        );
    }
}
