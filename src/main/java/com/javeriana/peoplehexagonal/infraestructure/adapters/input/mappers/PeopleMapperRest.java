package com.javeriana.peoplehexagonal.infraestructure.adapters.input.mappers;

import com.javeriana.peoplehexagonal.domain.models.People;
import com.javeriana.peoplehexagonal.infraestructure.adapters.input.models.request.PeopleRequest;
import com.javeriana.peoplehexagonal.infraestructure.adapters.input.models.response.PeopleResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeopleMapperRest {

    People fromRequestToDomain(PeopleRequest peopleRequest);

    PeopleResponse fromDomainToResponse(People people);
}