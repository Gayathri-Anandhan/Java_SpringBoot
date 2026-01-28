package com.example.EmployeeApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.EmployeeApp.model.Employee;

public interface EmployeeRepo extends MongoRepository<Employee, String> {
}
