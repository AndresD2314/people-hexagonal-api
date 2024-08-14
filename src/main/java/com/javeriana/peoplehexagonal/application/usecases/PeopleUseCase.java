package com.javeriana.peoplehexagonal.application.usecases;

import com.javeriana.peoplehexagonal.application.ports.input.PeopleInputPort;
import com.javeriana.peoplehexagonal.application.ports.output.PeopleOutputPort;
import com.javeriana.peoplehexagonal.domain.models.People;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PeopleUseCase implements PeopleInputPort {

    private final PeopleOutputPort peopleOutputPort;

    @Override
    public List<People> getAllPeople() {
        return peopleOutputPort.findAll();
    }

    @Override
    public People getPeopleById(Long id) {
        return peopleOutputPort.findById(id);
    }

    @Override
    public People getPeopleByEmail(String email) {
        return peopleOutputPort.findByEmail(email);
    }

    @Override
    public People createNewPeople(People people) {
        return peopleOutputPort.save(people);
    }

    @Override
    public People updatePeople(Long id, People people) {
        People existingPerson = peopleOutputPort.findByEmail(people.getEmail());

        if (existingPerson != null && !existingPerson.getId().equals(id))
            throw new IllegalArgumentException("Este email esta siendo usado por otra persona");

        People updatedPeople = peopleOutputPort.findById(id);

        if (updatedPeople != null) {
            updatedPeople.setAge(people.getAge());
            updatedPeople.setName(people.getName());
            updatedPeople.setPhone(people.getPhone());
            peopleOutputPort.save(updatedPeople);
        }

        return null;
    }

    @Override
    public void deletePeople(Long id) {
        People deletedPeople = peopleOutputPort.findById(id);

        if (deletedPeople != null)
            peopleOutputPort.deleteById(deletedPeople.getId());
    }
}
