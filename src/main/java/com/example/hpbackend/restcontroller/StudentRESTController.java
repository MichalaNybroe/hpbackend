package com.example.hpbackend.restcontroller;

import com.example.hpbackend.model.Student;
import com.example.hpbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("managing/student")
public class StudentRESTController {

    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public List<Student> showAllStudents() {
        return studentService.showAllStudents();
    }

    /*
    Metode til at udhente alle elever fra givent hus
    */
    @GetMapping("all/{house}")
    public List<Student> showAllStudentsFromHouse(@PathVariable String house) {
        return studentService.showAllFromHouse(house);
    }

}
