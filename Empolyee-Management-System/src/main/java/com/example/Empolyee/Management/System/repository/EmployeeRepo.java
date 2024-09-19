package com.example.Empolyee.Management.System.repository;

import com.example.Empolyee.Management.System.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    List<Employee> findByDepartmentId(int id);
}
