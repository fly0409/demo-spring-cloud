package com.iisi.demospringcloud.controller;

import com.iisi.demospringcloud.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class EmpConsumerController {

    private final RestTemplate restTemplate;

    private final String PROVIDER_URL = "http://localhost:8001";

    private final Logger log = LoggerFactory.getLogger(EmpConsumerController.class);

    public EmpConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/get/{id}")
    public Employee get(@PathVariable String id) {

        return restTemplate.getForObject(PROVIDER_URL + "/get/" + id, Employee.class);
    }

    @GetMapping("/getAll")
    public List<Employee> getAll() {
        log.info("getAll in consumer");
        return restTemplate.getForObject(PROVIDER_URL + "/getAll", List.class);
    }

    @PostMapping("/add")
    public Employee add(@RequestBody Employee emp){
        return restTemplate.postForObject(PROVIDER_URL + "add",emp,Employee.class);
    }

    @GetMapping("/consumer/dept/discovery")
    public Object discovery(){
        return restTemplate.getForObject(PROVIDER_URL + "/dept/discovery",Object.class);
    }
}
