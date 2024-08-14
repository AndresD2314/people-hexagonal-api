package com.javeriana.peoplehexagonal.infraestructure.adapters.input.controllers;

import com.javeriana.peoplehexagonal.application.ports.input.PeopleInputPort;
import com.javeriana.peoplehexagonal.domain.models.People;
import com.javeriana.peoplehexagonal.infraestructure.adapters.input.mappers.PeopleMapperRest;
import com.javeriana.peoplehexagonal.infraestructure.adapters.input.models.request.PeopleRequest;
import com.javeriana.peoplehexagonal.infraestructure.adapters.input.models.response.PeopleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/people")
@RequiredArgsConstructor
public class PeopleController {

    private final PeopleInputPort peopleInputPort;
    private final PeopleMapperRest peopleMapper;

    @GetMapping
    public ResponseEntity<List<PeopleResponse>> getAllPeople() {
        List<People> peopleList = peopleInputPort.getAllPeople();
        List<PeopleResponse> response = peopleList.stream()
                .map(peopleMapper::fromDomainToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeopleResponse> getPeopleById(@PathVariable Long id) {
        People people = peopleInputPort.getPeopleById(id);
        if (people == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(peopleMapper.fromDomainToResponse(people));
    }

    @GetMapping("/{email}")
    public ResponseEntity<PeopleResponse> getPeopleByEmail(@PathVariable String email) {
        People people = peopleInputPort.getPeopleByEmail(email);
        if (people == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(peopleMapper.fromDomainToResponse(people));
    }


    @PostMapping
    public ResponseEntity<PeopleResponse> createNewPeople(@RequestBody PeopleRequest request) {
        People people = peopleMapper.fromRequestToDomain(request);
        People createdPeople = peopleInputPort.createNewPeople(people);
        return ResponseEntity.ok(peopleMapper.fromDomainToResponse(createdPeople));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeopleResponse> updatePeople(@PathVariable Long id, @RequestBody PeopleRequest request) {
        People people = peopleMapper.fromRequestToDomain(request);
        People updatedPeople = peopleInputPort.updatePeople(id, people);
        if (updatedPeople == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(peopleMapper.fromDomainToResponse(updatedPeople));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePeople(@PathVariable Long id) {
        peopleInputPort.deletePeople(id);
        return ResponseEntity.noContent().build();
    }
}
