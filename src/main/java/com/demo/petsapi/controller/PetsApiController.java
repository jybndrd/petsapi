package com.demo.petsapi.controller;

import com.demo.petsapi.entity.Person;
import com.demo.petsapi.entity.Pet;
import com.demo.petsapi.service.PersonService;
import com.demo.petsapi.exception.ApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author jandrada
 */
@RestController("/api/petsapi")
public class PetsApiController {

    private final PersonService personService;

    public PetsApiController(PersonService personService) {
        this.personService = personService;
    }

    // Sanity check for api connectivity
    @GetMapping("/sanityCheck")
    public ResponseEntity<String> sanityCheck() {
        return ResponseEntity.ok("Welcome to Pets API!");
    }

    @GetMapping("/getAllPersons")
    public ResponseEntity<List<Person>> getAllPersons() {

        // Throw error if no records
       return Optional.of(personService.getAllPersons())
               .map(ResponseEntity::ok)
               .orElseThrow(ApplicationException::new);
    }

    @GetMapping("/getPet/{personId}")
    public ResponseEntity<List<Pet>> getPet(@PathVariable Long personId) {

        return Optional.of(personId)
                .map(personService::findPersonById)
                .map(Person::getPets)
                .map(ResponseEntity::ok)
                .orElseThrow(ApplicationException::new);
    }

    @PostMapping("/addPet/{personId}/{petName}")
    public ResponseEntity<Pet> addPet(@PathVariable Long personId, @PathVariable String petName) {

        return Optional.of(personService.addPets(personId, petName))
                .map(ResponseEntity::ok)
                .orElseThrow(ApplicationException::new);
    }
}
