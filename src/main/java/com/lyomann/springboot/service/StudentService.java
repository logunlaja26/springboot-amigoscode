package com.lyomann.springboot.service;

import com.lyomann.springboot.EmailValidator;
import com.lyomann.springboot.exceptions.ApiRequestException;
import com.lyomann.springboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class StudentService {
    private final StudentDataAccessService studentDataAccessService;
    private final EmailValidator emailValidator;

    @Autowired
    public StudentService(StudentDataAccessService studentDataAccessService, EmailValidator emailValidator) {
        this.studentDataAccessService = studentDataAccessService;
        this.emailValidator = emailValidator;
    }

    public List<Student> getAllStudents() {
        return studentDataAccessService.selectAllStudents();
    }

    public void addNewStudent(Student student) {
        addNewStudent(null,student);
    }


    void addNewStudent(UUID studentID, Student student) {
        UUID newStudentId = Optional.ofNullable(studentID).orElse(UUID.randomUUID());
        // Validate emails
        if(!emailValidator.test(student.getEmail())){
            throw new ApiRequestException(student.getEmail() + " is not valid");
        }
        //Verify that email is not taken
        studentDataAccessService.insertStudent(newStudentId, student);
    }

}
