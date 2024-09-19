package com.example.Empolyee.Management.System.repository;

import com.example.Empolyee.Management.System.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}
