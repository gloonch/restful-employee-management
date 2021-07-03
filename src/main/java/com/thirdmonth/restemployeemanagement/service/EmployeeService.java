package com.thirdmonth.restemployeemanagement.service;

import com.thirdmonth.restemployeemanagement.model.Employee;
import com.thirdmonth.restemployeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee register(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update(Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());
        if (optionalEmployee.isPresent()) {
            Employee emp = optionalEmployee.get();
            emp.setId(employee.getId());
            emp.setName(employee.getName());
            emp.setEmail(employee.getEmail());
            return employeeRepository.save(emp);
        }
        return null;
    }

    public Long delete(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeRepository.delete(optionalEmployee.get());
            return id;
        }
        return Long.valueOf(-1);
    }
}
