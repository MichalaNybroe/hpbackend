package com.example.hpbackend.service;

import com.example.hpbackend.model.Student;
import com.example.hpbackend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> showAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> showAllFromHouse(String house) {
        return studentRepository.findByHouse(house);
    }

}
