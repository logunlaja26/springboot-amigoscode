package com.lyomann.springboot.service;

import com.lyomann.springboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class StudentService {
    private final StudentDataAccessService studentDataAccessService;

    @Autowired
    public StudentService(StudentDataAccessService studentDataAccessService) {
        this.studentDataAccessService = studentDataAccessService;
    }

    public List<Student> getAllStudents() {
        return studentDataAccessService.selectAllStudents();
    }

    public void addNewStudent(Student student) {
        addNewStudent(null,student);
    }


    void addNewStudent(UUID studentID, Student student) {
        UUID newStudentId = Optional.ofNullable(studentID).orElse(UUID.randomUUID());

        //Verify that email is not taken
        studentDataAccessService.insertStudent(newStudentId, student);
    }
}
