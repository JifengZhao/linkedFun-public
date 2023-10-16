package com.linkedfun.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<List<Student>> findStudentByEmail(String email);

    @Query("UPDATE Student s SET s.name = ?2, s.email = ?3 WHERE s.id = ?1")
    void updateStudentById(Long id, String name, String email);
}
