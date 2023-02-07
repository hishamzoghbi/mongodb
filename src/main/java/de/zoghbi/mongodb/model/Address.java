package de.zoghbi.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hisham.zoghbi or 07.02.23
 */
@AllArgsConstructor
@Data
public class Address {
    private String country;
    private String city;
    private String code;
}
