package com.javeriana.peoplehexagonal.infraestructure.adapters.output.mappers;

import com.javeriana.peoplehexagonal.domain.models.People;
import com.javeriana.peoplehexagonal.infraestructure.adapters.output.entities.PeopleEntity;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface PeopleMapper {

    PeopleEntity fromDomainToEntity(People people);

    People fromEntityToDomain(PeopleEntity peopleEntity);
}