package com.linkedfun.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/fakedata")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/realdata")
    public List<Student> getStudents2(){
        return studentService.getStudents2();
    }

    @PostMapping("/addall")
    public void addAll(){
        studentService.saveAll(studentService.getStudents());
    }

    @PostMapping("/addstudent")
    public void addStudent(@RequestBody Student student){
        System.out.println("============================");
        System.out.println("This is StudentService.addStudent() : " + student);
        try {
            studentService.addStudent(student);
        }catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }
    @DeleteMapping("/deletestudent/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        if(id == null){
            System.out.println("The given id is null!");
            return;
        }
        try {
            studentService.deleteStudentById(id);
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }

    @PutMapping("/updatestudent/{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);
    }

    @GetMapping("/testrecord")
    public TestData testRecord (){

        return new TestData("testName", 1L);
    }
    record TestData(String testName, Long testLong){

    }


}
