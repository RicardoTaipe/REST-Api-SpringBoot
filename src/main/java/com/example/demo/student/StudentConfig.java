package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student miriam = new Student(
                    "miriam",
                    "miriam.ipsum@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );
            Student alex = new Student(
                    "alex",
                    "alex.ipsum@gmail.com",
                    LocalDate.of(1993, Month.JANUARY, 28)
            );
            repository.saveAll(List.of(miriam,alex));
        };
    }
}
