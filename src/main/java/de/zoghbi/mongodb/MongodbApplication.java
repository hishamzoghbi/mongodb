package de.zoghbi.mongodb;

import de.zoghbi.mongodb.enumeration.Gender;
import de.zoghbi.mongodb.model.Address;
import de.zoghbi.mongodb.model.Student;
import de.zoghbi.mongodb.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class MongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository, MongoTemplate mongoTemplate){
		return args -> {
			Address address = new Address(
					"Germany",
					"Gelsenkirchen",
					"435366"
			);
			String email = "elyana.zoghbi@test.de";
			Student student = new Student(
					"Elyana",
					"Zoghbi",
					Gender.FEMALE,
					email,
					address,
					List.of("Physik", "Math"),
					BigDecimal.TEN,
					LocalDateTime  .now()
			);

			//usingMongoTemplateAndQuery(studentRepository, mongoTemplate, email, student);

			studentRepository.findStudentByEmail(email)
					.ifPresentOrElse(s -> { System.out.println(s + " exists");},
							()->{ System.out.println("Insert " + student);
								studentRepository.insert(student);
					});
		};
	}

	private static void usingMongoTemplateAndQuery(StudentRepository studentRepository, MongoTemplate mongoTemplate, String email, Student student) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		List<Student> studentList = mongoTemplate.find(query, Student.class);

		if(studentList.size() > 1){
			throw new IllegalStateException("many Students with email found" + email);
		}

		if(studentList.isEmpty()){
			studentRepository.insert(student);
		}
	}

}
