package com.linkedfun.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.linkedfun.student.Student;


@RestController
@RequestMapping(path = "/hello")
public class HolleWorld {
    @GetMapping
    public List<Student> sayHolleWorld()
    {
        return List.of(
                new Student(1l,"Justin", LocalDate.of(1979, Month.JUNE,17),"jifengzhao88@gmail.com","123 Mercer Avenue",100),
                new Student(2l,"Tina", LocalDate.of(1979,Month.JUNE,17),"jifengzhao88@gmail.com","123 Mercer Avenue",100),
                new Student(3l,"Alexander", LocalDate.of(2016,Month.DECEMBER,20),"jifengzhao88@gmail.com","123 Mercer Avenue",100),
                new Student(4l,"William", LocalDate.of(2016, Month.DECEMBER,20),"jifengzhao88@gmail.com","123 Mercer Avenue",100)
        );
    }
}
