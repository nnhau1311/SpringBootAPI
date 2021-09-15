package com.example.springbootapi.repository;
import java.util.List;

import com.example.springbootapi.entity.Student;
import org.springframework.data.repository.CrudRepository;
public interface EmployeeRepository extends CrudRepository<Student, Long> {
    List<Student> findByLastName(String lastName);

    Student findById(long id);
}

