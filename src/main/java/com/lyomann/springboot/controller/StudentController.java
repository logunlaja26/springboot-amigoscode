package com.lyomann.springboot.controller;

import com.lyomann.springboot.exceptions.ApiRequestException;
import com.lyomann.springboot.model.Student;
import com.lyomann.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("students")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        throw new ApiRequestException("Oops couldn't get all students");
        //return studentService.getAllStudents();
    }

    @PostMapping
    public void addNewStudent(@RequestBody Student student){
        System.out.println(student);
        studentService.addNewStudent(student);
    }
}

