package com.javeriana.peoplehexagonal.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class People {
    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private Long phone;
    private String email;
}
