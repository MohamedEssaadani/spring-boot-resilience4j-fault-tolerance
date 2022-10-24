package org.essaadani.springbootresilience4jfaulttolerance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootResilience4jFaultToleranceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootResilience4jFaultToleranceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().rootUri("http://localhost:9090")
                .build();
    }
}
