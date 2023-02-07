package de.zoghbi.mongodb.repository;

import de.zoghbi.mongodb.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * @author hisham.zoghbi or 07.02.23
 */
public interface StudentRepository extends MongoRepository<Student, String> {
    Optional<Student> findStudentByEmail(String email);
}
