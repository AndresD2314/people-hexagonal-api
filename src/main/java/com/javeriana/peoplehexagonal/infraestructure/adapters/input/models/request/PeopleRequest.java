package com.javeriana.peoplehexagonal.infraestructure.adapters.input.models.request;

import lombok.Data;

@Data
public class PeopleRequest {
    private String name;
    private String lastName;
    private Integer age;
    private Long phone;
    private String email;
}