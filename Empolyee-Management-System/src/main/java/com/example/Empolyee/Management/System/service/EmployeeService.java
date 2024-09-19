package com.example.Empolyee.Management.System.service;

import com.example.Empolyee.Management.System.customException.DepartmentNotFoundException;
import com.example.Empolyee.Management.System.customException.EmployeeNotFoundException;
import com.example.Empolyee.Management.System.entity.Department;
import com.example.Empolyee.Management.System.entity.Employee;
import com.example.Empolyee.Management.System.repository.DepartmentRepo;
import com.example.Empolyee.Management.System.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;


    // Create Employee
    public ResponseEntity<Employee> createEmployee(Employee employee, int departmentId) {

        Department department = departmentRepo.findById(departmentId)
                .orElseThrow(() -> new DepartmentNotFoundException("Department now found...."));

        employee.setDepartment(department);

        Employee savedEmployee = employeeRepo.save(employee);
        if(savedEmployee == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    // Get All Employees
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    // Get Employee By Department
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(int departmentId) {
        Department department = departmentRepo.findById(departmentId)
                .orElseThrow(() -> new DepartmentNotFoundException("Category Not found... Try with another category"));

        List<Employee> employees = employeeRepo.findByDepartmentId(departmentId);
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    // update Employee
    public ResponseEntity<Employee> updateEmployee(Employee employee, int id) {
        Employee existingEmployee = employeeRepo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found.. check again bro"));

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());

        employeeRepo.save(existingEmployee);

        return ResponseEntity.status(HttpStatus.OK).body(existingEmployee);
    }

    // delete Employee
    public ResponseEntity<String> deleteEmployee(int id) {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(()
                        -> new EmployeeNotFoundException("Employee not present.. so how can I delete Brother"));

        employeeRepo.delete(employee);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Employee deleted successfully...!");
    }
}
