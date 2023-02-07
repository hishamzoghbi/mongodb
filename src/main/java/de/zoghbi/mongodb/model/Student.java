package de.zoghbi.mongodb.model;

import de.zoghbi.mongodb.enumeration.Gender;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * @author hisham.zoghbi or 07.02.23
 */
@Document
@Data
public class Student {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private Gender gender;
    @Indexed(unique = true)
    private String email;
    private Address address;
    private List<String> favouriteSubject;
    private BigDecimal total;
    private LocalDateTime localDateTime;

    public Student(String firstname,
                   String lastname,
                   Gender gender,
                   String email,
                   Address address,
                   List<String> favouriteSubject,
                   BigDecimal total,
                   LocalDateTime localDateTime) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.favouriteSubject = favouriteSubject;
        this.total = total;
        this.localDateTime = localDateTime;
    }

}
