package com.example.Empolyee.Management.System.controller;

import com.example.Empolyee.Management.System.entity.Employee;
import com.example.Empolyee.Management.System.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee_management")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // add employee
    @PostMapping(path = "/addEmployee/{departmentId}")
    public ResponseEntity<Employee> createEmployee(
            @RequestBody Employee employee, @PathVariable int departmentId) {
        return employeeService.createEmployee(employee, departmentId);
    }

    // get all employee
    @GetMapping(path = "/getEmployees")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    // get employees by Category id
    @GetMapping(path = "/getEmployeeByDepartmentId/{departmentId}")
    public ResponseEntity<List<Employee>> getEmployeeByDepartmentId(@PathVariable int departmentId) {
        return employeeService.getEmployeesByDepartment(departmentId);
    }


    // update employee
    @PutMapping(path = "/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable int id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(employee, id);
    }

    // delete employee
    @DeleteMapping(path = "/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable int id) {
        return employeeService.deleteEmployee(id);
    }

}
