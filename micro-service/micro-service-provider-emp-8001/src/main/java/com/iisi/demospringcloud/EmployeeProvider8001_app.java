package com.iisi.demospringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//新的版本從@EnableEurekaClient改成@EnableDiscoveryClient
@EnableDiscoveryClient
public class EmployeeProvider8001_app {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeProvider8001_app.class, args);
    }

}
