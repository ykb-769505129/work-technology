package com.example;

import com.example.util.AppConstants;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 76950
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = AppConstants.BASE_PACKAGE)
@SpringBootApplication(scanBasePackages = {AppConstants.BASE_PACKAGE})
//@MapperScan(basePackages = "com.example.*")
public class YkbTechnologyApplication {

    public static void main(String[] args) {
        SpringApplication.run(YkbTechnologyApplication.class, args);
    }

}
