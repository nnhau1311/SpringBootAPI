package com.example.springbootapi.controller;
import com.example.springbootapi.entity.Student;
import com.example.springbootapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/employees")
public class EmployeeController
{
    @Autowired
    EmployeeRepository studentRepo;
    @GetMapping
    public List<Student> getStudents() {
        return (List<Student>) studentRepo.findAll();
    }
    @PostMapping
    public void postStudent(@RequestBody Student dto) {
        studentRepo.save(dto);
    }
    @GetMapping("/{id}")
    public Student getById(@PathVariable(required = true) long id) {
        return studentRepo.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) long id) {
        studentRepo.deleteById(id);
    }
}
