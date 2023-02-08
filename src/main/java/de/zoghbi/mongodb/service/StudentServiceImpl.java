package de.zoghbi.mongodb.service;

import de.zoghbi.mongodb.model.Student;
import de.zoghbi.mongodb.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hisham.zoghbi or 08.02.23
 */
@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public Student createStudent(Student student){return studentRepository.save(student);}

    public Student changeStudent(Student student){return studentRepository.save(student);}
}
