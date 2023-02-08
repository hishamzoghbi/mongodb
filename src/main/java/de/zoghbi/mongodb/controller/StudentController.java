package de.zoghbi.mongodb.controller;

import de.zoghbi.mongodb.model.Student;
import de.zoghbi.mongodb.service.StudentService;
import de.zoghbi.mongodb.service.StudentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hisham.zoghbi or 07.02.23
 */
@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentServiceImpl studentServiceImpl;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentServiceImpl.getAllStudents();
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student){
        return studentServiceImpl.createStudent(student);
    }

    @PutMapping("/student")
    public Student changeStudent(@RequestBody Student student){
        return studentServiceImpl.changeStudent(student);
    }

}
