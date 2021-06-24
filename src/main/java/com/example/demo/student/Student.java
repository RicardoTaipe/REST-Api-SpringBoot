package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "student_sequence")
    private Long id;
    private String name;
    private String email;
    private LocalDate dayOfBirth;
    @Transient
    private Integer age;

    public Student() {
    }

    public Student(Long id, String name, String email, LocalDate dayOfBirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dayOfBirth = dayOfBirth;
    }

    public Student(String name, String email, LocalDate dayOfBirth) {
        this.name = name;
        this.email = email;
        this.dayOfBirth = dayOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Integer getAge() {
        return Period.between(this.dayOfBirth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", age=" + age +
                '}';
    }
}
