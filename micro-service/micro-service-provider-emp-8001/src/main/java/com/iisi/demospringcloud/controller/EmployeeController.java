package com.iisi.demospringcloud.controller;

import com.iisi.demospringcloud.entity.Employee;
import com.iisi.demospringcloud.service.EmployeeService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Applications;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    private final DiscoveryClient discoveryClient;

    public EmployeeController(EmployeeService employeeService, DiscoveryClient discoveryClient) {
        this.employeeService = employeeService;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/get/{id}")
    public Employee get(@PathVariable String id) {
        Long idLong = Long.valueOf(id);
        return employeeService.get(idLong);
    }

    @GetMapping("/getAll")
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @PostMapping("/add")
    public Employee add(@RequestBody Employee emp) {
        return employeeService.addEmployee(emp);
    }

    /*
        感覺這個比較適合放在其他地方
     */
    @GetMapping("/dept/discovery")
    public Object discovery() {
        List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICE-EMP");
        srvList.forEach(ele -> {
            System.out.println(String.format("%s\t%s\t%s\t%s", ele.getServiceId(),
                    ele.getHost(), ele.getPort(), ele.getUri()));
        });
        return discoveryClient;
    }
}
