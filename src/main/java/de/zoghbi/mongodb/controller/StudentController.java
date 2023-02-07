package de.zoghbi.mongodb.controller;

import de.zoghbi.mongodb.model.Student;
import de.zoghbi.mongodb.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hisham.zoghbi or 07.02.23
 */
@RestController
@RequestMapping("api/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/student")
    public Student createStudent(Student student){
        return studentService.createStudent(student);
    }

}
