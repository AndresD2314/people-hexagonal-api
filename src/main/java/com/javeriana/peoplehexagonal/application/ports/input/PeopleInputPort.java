package com.javeriana.peoplehexagonal.application.ports.input;

import com.javeriana.peoplehexagonal.domain.models.People;

import java.util.List;

public interface PeopleInputPort {

    List<People> getAllPeople();
    People getPeopleById(Long id);
    People createNewPeople(People people);
    People updatePeople(Long id, People people);
    void deletePeople(Long id);
}
