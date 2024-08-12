package com.javeriana.peoplehexagonal.infraestructure.adapters.input.models.response;

import lombok.Data;

@Data
public class PeopleResponse {
    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private Long phone;
}