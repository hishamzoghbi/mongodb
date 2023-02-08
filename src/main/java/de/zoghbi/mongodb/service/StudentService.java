package de.zoghbi.mongodb.service;

import de.zoghbi.mongodb.model.Student;
import de.zoghbi.mongodb.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hisham.zoghbi or 07.02.23
 */
public interface StudentService {
    public List<Student> getAllStudents();
    public Student createStudent(Student student);
    public Student changeStudent(Student student);
}
