package com.javeriana.peoplehexagonal.infraestructure.adapters.output.repository;

import com.javeriana.peoplehexagonal.infraestructure.adapters.output.entities.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleEntityRepository extends JpaRepository<PeopleEntity, Long> {
    PeopleEntity findByEmail(String email);
}
