package com.wcq.quickstartconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.wcq")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.wcq.client")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}