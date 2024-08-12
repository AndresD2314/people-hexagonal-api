package com.javeriana.peoplehexagonal.infraestructure.adapters.output;

import com.javeriana.peoplehexagonal.application.ports.output.PeopleOutputPort;
import com.javeriana.peoplehexagonal.domain.models.People;
import com.javeriana.peoplehexagonal.infraestructure.adapters.output.entities.PeopleEntity;
import com.javeriana.peoplehexagonal.infraestructure.adapters.output.mappers.PeopleMapper;
import com.javeriana.peoplehexagonal.infraestructure.adapters.output.repository.PeopleEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PeopleOutputAdapter implements PeopleOutputPort {

    private final PeopleEntityRepository peopleEntityRepository;
    private final PeopleMapper peopleMapper;

    @Override
    public List<People> findAll() {
        return peopleEntityRepository.findAll().stream()
                .map(peopleMapper::fromEntityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public People findById(Long id) {
        return peopleEntityRepository.findById(id)
                .map(peopleMapper::fromEntityToDomain)
                .orElse(null);
    }

    @Override
    public People save(People people) {
        PeopleEntity entity = peopleMapper.fromDomainToEntity(people);
        return peopleMapper.fromEntityToDomain(peopleEntityRepository.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        peopleEntityRepository.deleteById(id);
    }
}

