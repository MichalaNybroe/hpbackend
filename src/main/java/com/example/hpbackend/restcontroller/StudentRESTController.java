package com.example.hpbackend.restcontroller;

import com.example.hpbackend.model.Student;
import com.example.hpbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    // Gør denne mulig + muliggør at søge på studentid i samme felt
    @GetMapping("/all/house")
    public List<Student> showAllStudentsFromHouse(@RequestParam String name) {
        return studentService.showAllFromHouse(name);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
}
