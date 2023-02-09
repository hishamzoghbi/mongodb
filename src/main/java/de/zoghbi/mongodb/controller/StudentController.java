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
@RequestMapping("api/students")
@AllArgsConstructor
public class StudentController {

    private final StudentServiceImpl studentServiceImpl;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentServiceImpl.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") String id){return studentServiceImpl.getStudentById(id);}

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        return studentServiceImpl.addStudent(student);
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student){
        return studentServiceImpl.updateStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable("id") String id){
        studentServiceImpl.deleteStudent(id);
    }

}
