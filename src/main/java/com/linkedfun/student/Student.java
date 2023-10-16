package com.linkedfun.student;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

@Entity
@Table

public class Student {
    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;
    private String name;
    private LocalDate dob;
    @Transient
    private Integer age;
    @Transient
    private LocalTime addedTime;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public Student(Long id, String name, LocalDate dob, String email, String address, int age) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.age = age;
    }

    public Student() {

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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalTime getAddedTime() {
        return LocalTime.now();
    }

    public void setAddedTime(LocalTime addedTime) {
        this.addedTime = addedTime;
    }
}
