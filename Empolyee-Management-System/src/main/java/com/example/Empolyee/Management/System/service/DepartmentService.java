package com.example.Empolyee.Management.System.service;

import com.example.Empolyee.Management.System.customException.DepartmentNotFoundException;
import com.example.Empolyee.Management.System.entity.Department;
import com.example.Empolyee.Management.System.repository.DepartmentRepo;
import com.sun.net.httpserver.HttpsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.zip.DataFormatException;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    // add department
    public ResponseEntity<Department> addDepartment(Department department) {
        Department savedDepartment = departmentRepo.save(department);
        if(savedDepartment == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartment);
    }

    //get all departments
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentRepo.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(departments);
    }

    // update departments
    public ResponseEntity<Department> updateDepartment(Department department, int id) {

        Department exisitngDepartment = departmentRepo.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));

        exisitngDepartment.setName(department.getName());
        departmentRepo.save(exisitngDepartment);
        return ResponseEntity.status(HttpStatus.OK).body(exisitngDepartment);
    }

    // delete departments
    public ResponseEntity<String> deleteDepartment(int id) {
        departmentRepo.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Department Deleted");
    }
}
