package com.example.Empolyee.Management.System.controller;

import com.example.Empolyee.Management.System.entity.Department;
import com.example.Empolyee.Management.System.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee_management")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // add department
    @PostMapping(path = "/addDepartment")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    // get all departments
    @GetMapping(path = "/getDepartments")
    public ResponseEntity<List<Department>> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    // update departments
    @PutMapping(path = "/updateDepartment/{id}")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department, @PathVariable int id) {
        return departmentService.updateDepartment(department, id);
    }

    // delete department
    @DeleteMapping(path = "/deleteDepartment/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable int id) {
        return departmentService.deleteDepartment(id);
    }

}
