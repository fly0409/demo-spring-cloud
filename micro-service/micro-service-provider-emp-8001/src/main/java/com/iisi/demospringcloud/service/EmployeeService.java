package com.iisi.demospringcloud.service;

import com.iisi.demospringcloud.entity.Employee;
import com.iisi.demospringcloud.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee emp){
        return employeeRepository.save(emp);
    }

    public Employee get(Long id){
        Optional<Employee> option = employeeRepository.findById(id);
        return option.orElse(null);
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }
}
