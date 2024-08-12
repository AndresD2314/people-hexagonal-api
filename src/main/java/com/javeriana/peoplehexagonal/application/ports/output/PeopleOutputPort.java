package com.javeriana.peoplehexagonal.application.ports.output;

import com.javeriana.peoplehexagonal.domain.models.People;

import java.util.List;

public interface PeopleOutputPort {
    List<People> findAll();
    People findById(Long id);
    People save(People people);
    void deleteById(Long id);

}
