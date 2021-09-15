package com.example.springbootapi;

import com.example.springbootapi.repository.EmployeeRepository;
import com.example.springbootapi.entity.Student;
import com.example.springbootapi.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootApiApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringBootApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApiApplication.class, args);
    }
    public CommandLineRunner run(EmployeeRepository repository) {
        return (args) -> {
            // lưu vào một vài sinh viên
            repository.save(new Student("Lee", "Loan"));
            repository.save(new Student("Seo", "Ben"));
            repository.save(new Student("Pack", "HSeo"));
            repository.save(new Student("Michel", "Jon"));

            // Hiển thị tât cả sinh viên
            System.out.println("Students found with findAll():");
            System.out.println("-------------------------------");
            for (Student Student : repository.findAll()) {
                System.out.println(Student.toString());
            }
            System.out.println("");

            // Hiển thị sinh viên theo ID
            Student Student = repository.findById(1L);
            System.out.println("Tìm sinh viên theo findById(1L):");
            System.out.println("--------------------------------");
            System.out.println(Student.toString());
            System.out.println("");

            // Hiển thị theo last name
            System.out.println("Tìm kiến theo findByLastName('Loan'):");
            System.out.println("--------------------------------------------");
            repository.findByLastName("Loan").forEach(name -> {
                System.out.println(name.toString());
            });
            // for (Student name : repository.findByLastName("Loan")) {
            //     System.out.println(name.toString());
            // }
            System.out.println("");
        };
    }


}
