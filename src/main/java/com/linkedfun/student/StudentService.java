package com.linkedfun.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents2(){
        return studentRepository.findAll();
    }

    public void saveAll(List<Student> students){
        studentRepository.saveAll(students);
    }

    public List<Student> getStudents(){
        return List.of(
                new Student(1l,"Justin", LocalDate.of(1979, Month.JUNE,17),"jifengzhao88@gmail.com","123 Mercer Avenue",100),
                new Student(2l,"Tina", LocalDate.of(1979,Month.JUNE,17),"jifengzhao88@gmail.com","123 Mercer Avenue",100),
                new Student(3l,"Alexander", LocalDate.of(2016,Month.DECEMBER,20),"jifengzhao88@gmail.com","123 Mercer Avenue",100),
                new Student(4l,"William", LocalDate.of(2016, Month.DECEMBER,20),"jifengzhao88@gmail.com","123 Mercer Avenue",100)
        );
    }

    public void addStudent(Student student)
    {
        System.out.println("===============================");
        System.out.println(student.getEmail());


        Optional<List<Student>> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("The Email: " + student.getEmail() +" is taken!");
        }else{
            studentRepository.save(student);
        }
    }

    public void deleteStudentById(Long id){
        if(!studentRepository.existsById(id)){
            throw new IllegalStateException("The student does not exist with the ID: " + id);
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id: " + id + " dose not exist!"
                ));

    }

}
