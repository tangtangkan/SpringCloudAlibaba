package com.ttk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsulOneApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulOneApplication.class, args);
    }
}
