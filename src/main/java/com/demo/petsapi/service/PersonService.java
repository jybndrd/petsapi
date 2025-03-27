package com.demo.petsapi.service;

import com.demo.petsapi.entity.Person;
import com.demo.petsapi.entity.Pet;
import com.demo.petsapi.exception.PersonNotExistException;
import com.demo.petsapi.repository.PersonRepository;
import com.demo.petsapi.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jandrada
 */
@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PetRepository petRepository;

    PersonService(PersonRepository personRepository, PetRepository petRepository) {
        this.personRepository = personRepository;
        this.petRepository = petRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person findPersonById(Long personId) {
        // check if person is existing and throw exception if not existing.
        return personRepository.findById(personId).orElseThrow(PersonNotExistException::new);
    }

    // it would be better if this method is in a PetService, but for easier implementation, it is placed here
    public Pet addPets(Long personId, String petName) {
        // this will throw an error if it's not existing
        Person person = findPersonById(personId);

        Pet pet = new Pet();
        pet.setName(petName);
        pet.setPerson(person);

        return petRepository.save(pet);
    }
}
