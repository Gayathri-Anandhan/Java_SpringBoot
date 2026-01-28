package com.example.EmployeeApp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.EmployeeApp.model.Employee;
import com.example.EmployeeApp.repository.EmployeeRepo;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepo repository;

    // Landing Page
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("employee", new Employee());
        return "index";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        repository.save(employee); // this saves to MongoDB
        return "redirect:/displayAll"; // redirect to display all after save
    }

    // Display All
    @GetMapping("/displayAll")
    public String displayAll(Model model) {
        List<Employee> list = repository.findAll();
        model.addAttribute("employees", list); // match ${employees} in Thymeleaf
        return "displayAll";
    }

    // Display One
    @GetMapping("/display/{id}")
    public String displayById(@PathVariable String id, Model model) {
        Employee e = repository.findById(id).orElse(null);
        model.addAttribute("employee", e);
        return "employee";
    }
}
