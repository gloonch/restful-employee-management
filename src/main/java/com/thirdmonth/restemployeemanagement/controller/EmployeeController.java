package com.thirdmonth.restemployeemanagement.controller;

import com.thirdmonth.restemployeemanagement.model.Employee;
import com.thirdmonth.restemployeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


//    read all employees GET /
//    TODO maybe need to do something about responseBody
    @GetMapping("/")
    public List<Employee> all(){
        return employeeService.getAll();
    }

//    save employee POST /
    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeService.register(employee);
    }

//    update employee PUT /
    @PutMapping
    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

//    delete employee DELETE
//    TODO need to do sth about name/value id thing
    @DeleteMapping
    public Long delete(@RequestParam(name = "id", value = "id") Long id){
        return employeeService.delete(id);
    }

}
